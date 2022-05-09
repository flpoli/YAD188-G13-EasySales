package com.poli.prevendasomie.signup.domain.repository

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.signup.domain.model.UserData
import retrofit2.Response

interface SignUpRepository {

    suspend fun signUp(userData: UserData): Resource<Response<Unit>>
}
