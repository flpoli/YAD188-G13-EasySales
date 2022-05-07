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

        return when (val signUpResult = signUpRepository.signUp(userData)) {

            is Resource.Success -> {

                val result = signUpResult.data


                SignUpResult.Success
            }
            is Resource.Error -> {

                SignUpResult.Failure.Unknown
            }
            else -> {
                SignUpResult.Failure.Unknown
            }
        }
    }
}
