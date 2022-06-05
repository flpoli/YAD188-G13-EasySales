package com.poli.easysales.signup.domain.usecase

import com.poli.easysales.signup.domain.model.SignUpResult
import com.poli.easysales.signup.domain.model.UserData

interface SignUpUseCase {

    suspend operator fun invoke(userData: UserData): SignUpResult
}
