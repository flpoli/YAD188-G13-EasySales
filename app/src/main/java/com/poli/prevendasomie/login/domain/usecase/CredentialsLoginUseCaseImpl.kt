package com.poli.prevendasomie.login.domain.usecase

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.Result
import com.poli.prevendasomie.data.remote.toToken
import com.poli.prevendasomie.domain.repository.DataStoreOperations
import com.poli.prevendasomie.login.domain.model.*
import com.poli.prevendasomie.login.domain.repository.LoginRepository
import com.poli.prevendasomie.login.domain.repository.TokenRepository
import javax.inject.Inject

class CredentialsLoginUseCaseImpl @Inject constructor(
    private val loginRepository: LoginRepository,
    private val tokenRepository: TokenRepository,
    private val dataStore: DataStoreOperations

) : CredentialsLoginUseCase {

    override suspend fun invoke(credentials: Credentials): LoginResult {

        val validationResult = validateCredentials(credentials)

        if (validationResult != null) {
            return validationResult
        }

        val repoResult = loginRepository.login(credentials)

        when (repoResult) {

            is Resource.Success -> {
                val tokenResult = repoResult.data?.toToken()

                tokenRepository.storeToken(
                    Token(
                        AuthToken(tokenResult?.authToken!!.value),
                        TokenExpiry(""),
                        TokenType("")
                    )
                )

            }
        }
        return LoginResult.Success
    }

    private fun validateCredentials(credentials: Credentials): LoginResult.Failure.EmptyCredentials? {
        val emptyEmail = credentials.email.value.isEmpty()
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
