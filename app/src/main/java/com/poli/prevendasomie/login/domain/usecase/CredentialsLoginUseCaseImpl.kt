package com.poli.prevendasomie.login.domain.usecase

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.Result
import com.poli.prevendasomie.data.remote.toToken
import com.poli.prevendasomie.login.domain.model.*
import com.poli.prevendasomie.login.domain.repository.LoginRepository
import com.poli.prevendasomie.login.domain.repository.TokenRepository
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


        when(val repoResult = loginRepository.login(credentials)) {

            is Resource.Success -> {
                val tokenResult = repoResult.data?.headers()?.get("Authorization")

                if(tokenResult != null) {

                    tokenRepository.storeToken(
                        Token(
                            AuthToken(tokenResult)
                        )
                    )
                }



            }
            is Resource.Error -> {
                //loginResultForError(Result.Error(repoResult.data.errorBody()))
            }
        }
        return LoginResult.Success

//        return when (repoResult) {
//            is Result.Success -> {
//                tokenRepository.storeToken(repoResult.data.token)
//                LoginResult.Success
//            }
//            is Result.Error -> {
//                loginResultForError(repoResult)
//            }
//            else -> {println("else")}
//        }
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

