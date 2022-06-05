package com.poli.easysales.login.domain.repository

import com.poli.easysales.common.Resource
import com.poli.easysales.data.remote.dto.ResponseSignUpDto
import com.poli.easysales.login.domain.model.Credentials
import retrofit2.Response

interface LoginRepository {

    suspend fun login(credentials: Credentials): Resource<Response<Unit>>
    suspend fun getUserDetails(token: String): Resource<ResponseSignUpDto>
}
