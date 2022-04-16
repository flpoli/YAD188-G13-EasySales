package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.ResponseTokenDto
import com.poli.prevendasomie.login.domain.model.Credentials
import retrofit2.Response

interface LoginRepository {

     suspend fun login(credentials: Credentials): Resource<Response<Unit>>
}
