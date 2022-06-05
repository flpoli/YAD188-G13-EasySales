package com.poli.easysales.data.remote

import com.poli.easysales.data.remote.dto.ResponseSignUpDto
import com.poli.easysales.login.domain.model.Credentials
import com.poli.easysales.signup.domain.model.UserData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface BackEndApi {

    @POST("login")
    @Headers("Content-Type: application/json")
    suspend fun executeLogin(@Body credentials: Credentials): Response<Unit>

    @POST("users/registrations")
    @Headers("Content-Type: application/json")
    suspend fun userRegistration(@Body userData: UserData): Response<Unit>

    @POST("users/details")
    @Headers("Content-Type: application/json")
    suspend fun getUserDetails(@Header("Authorization") authToken: String): ResponseSignUpDto
}
