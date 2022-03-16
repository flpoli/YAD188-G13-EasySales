package com.poli.prevendasomie.signup.domain.repository

import com.poli.prevendasomie.data.Result
import com.poli.prevendasomie.signup.domain.model.SignUpResponse
import com.poli.prevendasomie.signup.domain.model.UserData

interface SignUpRepository {

    suspend fun signUp(userData: UserData): Result<SignUpResponse>
}