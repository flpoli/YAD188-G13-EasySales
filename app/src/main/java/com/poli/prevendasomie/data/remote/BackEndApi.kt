package com.poli.prevendasomie.data.remote

import retrofit2.http.POST

interface BackEndApi {

    @POST("users/registrations")
    suspend fun executeLogin(username: String, password: String)
}