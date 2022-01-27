package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.login.domain.model.Credentials
import com.poli.prevendasomie.login.domain.model.LoginResponse
import retrofit2.http.POST

interface BackEndApi {

    @POST("login")
    suspend fun executeLogin(credentials: Credentials): LoginResponse
}