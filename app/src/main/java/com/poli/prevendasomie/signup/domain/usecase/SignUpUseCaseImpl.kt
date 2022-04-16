package com.poli.prevendasomie.signup.domain.usecase

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.responses.toSignupResponse
import com.poli.prevendasomie.signup.domain.model.SignUpResult
import com.poli.prevendasomie.signup.domain.model.UserData
import com.poli.prevendasomie.signup.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpUseCaseImpl
@Inject constructor(
    private val signUpRepository: SignUpRepository
) : SignUpUseCase {

    override suspend fun invoke(userData: UserData): SignUpResult {

        val signUpResult = signUpRepository.signUp(userData)

        return when (signUpResult) {
            // TODO: melhorar isso dps
            is Resource.Success -> {

                val result = signUpResult.data?.toSignupResponse()
                SignUpResult.Success
            }
            is Resource.Error -> {
                println("Errinho aqui hein")
                SignUpResult.Failure.Unknown
            }
            else -> {
                println("else")
                SignUpResult.Failure.Unknown
            }
        }
    }
}
