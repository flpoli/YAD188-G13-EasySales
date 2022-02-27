package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.login.domain.model.Credentials
import com.poli.prevendasomie.login.domain.model.LoginResponse
import com.poli.prevendasomie.data.Result
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface BackEndApi {

    @POST("login")
    @Headers("Accept: application/json")
    suspend fun executeLogin(@Body credentials: Credentials): Result<LoginResponse>
}