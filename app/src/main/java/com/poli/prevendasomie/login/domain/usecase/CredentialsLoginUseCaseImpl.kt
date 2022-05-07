package com.poli.prevendasomie.login.domain.usecase

import android.util.Log
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.Result
import com.poli.prevendasomie.login.domain.model.AuthToken
import com.poli.prevendasomie.login.domain.model.Credentials
import com.poli.prevendasomie.login.domain.model.InvalidCredentialsException
import com.poli.prevendasomie.login.domain.model.LoginResult
import com.poli.prevendasomie.login.domain.model.Token
import com.poli.prevendasomie.login.domain.repository.LoginRepository
import com.poli.prevendasomie.login.domain.repository.TokenRepository
import retrofit2.HttpException
import javax.inject.Inject

class CredentialsLoginUseCaseImpl @Inject constructor(
    private val loginRepository: LoginRepository,
    private val tokenRepository: TokenRepository,

) : CredentialsLoginUseCase {

    override suspend fun invoke(credentials: Credentials): LoginResult {

        val validationResult = validateCredentials(credentials)

        if (validationResult != null) {
            return validationResult
        }

        return when (val repoResult = loginRepository.login(credentials)) {

            is Resource.Success -> {
                val tokenResult = repoResult.data?.headers()?.get("Authorization")

                if (tokenResult != null) {
                    tokenRepository.storeToken(
                        Token(
                            AuthToken(tokenResult)
                        )
                    )
                    loginRepository.getUserDetails(tokenResult)
                }
                LoginResult.Success
            }
            is Resource.Error -> {

                if (repoResult.data != null) {


                        Log.d("Reporesult -> Login", "${repoResult.data.code()}")

                        loginResultForError(
                            Result.Error(error = HttpException(repoResult.data))
                        )
                }

                LoginResult.Failure.Unknown

            }

            else -> {LoginResult.Failure.Unknown}
        }


    }

    private fun validateCredentials(credentials: Credentials): LoginResult.Failure.EmptyCredentials? {
        val emptyEmail = credentials.username.value.isEmpty()
        val emptyPassword = credentials.password.value.isEmpty()

        return if (emptyEmail || emptyPassword) {
            LoginResult.Failure.EmptyCredentials(
                emptyEmail = emptyEmail,
                emptyPassword = emptyPassword,
            )
        } else {
            null
        }
    }

    private fun loginResultForError(repoResult: Result.Error): LoginResult.Failure {
        return when (repoResult.error) {
            is InvalidCredentialsException -> {
                LoginResult.Failure.InvalidCredentials
            }
            else -> {
                LoginResult.Failure.Unknown
            }
        }
    }
}
