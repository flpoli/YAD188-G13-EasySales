package com.poli.easysales.signup.domain.repository

import com.poli.easysales.common.Resource
import com.poli.easysales.signup.domain.model.UserData
import retrofit2.Response

interface SignUpRepository {

    suspend fun signUp(userData: UserData): Resource<Response<Unit>>
}
