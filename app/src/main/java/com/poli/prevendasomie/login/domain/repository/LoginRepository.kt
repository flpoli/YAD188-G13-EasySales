package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.Result
import com.poli.prevendasomie.data.remote.ResponseTokenDto
import com.poli.prevendasomie.login.domain.model.Credentials
import com.poli.prevendasomie.login.domain.model.LoginResponse
import com.poli.prevendasomie.login.domain.model.Token
import retrofit2.Response

interface LoginRepository {

    suspend fun login(credentials: Credentials): Resource<ResponseTokenDto>
}
