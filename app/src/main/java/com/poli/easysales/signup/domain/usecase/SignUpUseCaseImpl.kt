package com.poli.easysales.signup.domain.usecase

import com.poli.easysales.common.Resource
import com.poli.easysales.signup.domain.model.SignUpResult
import com.poli.easysales.signup.domain.model.UserData
import com.poli.easysales.signup.domain.repository.SignUpRepository
import javax.inject.Inject

class SignUpUseCaseImpl
@Inject constructor(
    private val signUpRepository: SignUpRepository
) : SignUpUseCase {

    override suspend fun invoke(userData: UserData): SignUpResult {

        if (userData.password != userData.passwordConfirm) {

            return SignUpResult.Failure.ConfirmPasswordMatch
        }

        return when (val signUpResult = signUpRepository.signUp(userData)) {

            is Resource.Success -> {

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
