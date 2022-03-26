package com.poli.prevendasomie.signup.domain.usecase

import com.poli.prevendasomie.signup.domain.model.SignUpResult
import com.poli.prevendasomie.signup.domain.model.UserData

interface SignUpUseCase {

    suspend operator fun invoke(userData: UserData): SignUpResult
}