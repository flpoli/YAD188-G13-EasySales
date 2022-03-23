package com.poli.prevendasomie.signup.domain.usecase

import com.poli.prevendasomie.signup.domain.model.SignUpResponse
import com.poli.prevendasomie.signup.domain.model.SignUpResult
import com.poli.prevendasomie.signup.domain.model.UserData
import java.time.format.SignStyle

interface SignUpUseCase {

    suspend operator fun invoke(userData: UserData): SignUpResult
}