package com.poli.prevendasomie.signup.domain.usecase

import com.poli.prevendasomie.data.remote.BackEndApi
import com.poli.prevendasomie.signup.domain.model.SignUpResponse
import com.poli.prevendasomie.data.Result

import com.poli.prevendasomie.signup.domain.model.SignUpResult
import com.poli.prevendasomie.signup.domain.model.UserData
import com.poli.prevendasomie.signup.domain.repository.SignUpRepository
import javax.inject.Inject
import kotlin.math.sign

class SignUpUseCaseImpl
    @Inject constructor(
        private val signUpRepository: SignUpRepository
    ): SignUpUseCase {


    override suspend fun invoke(userData: UserData): SignUpResult {

        val signUpResult =  signUpRepository.signUp(userData)


        return when (signUpResult) {
            // TODO: melhorar isso dps
            is Result.Success -> {
                println("logayyy hein")
                SignUpResult.Success
            }
            is Result.Error -> {
                println("Errinho aqui hein")
                SignUpResult.Failure.Unknown

            }

        }



    }
}