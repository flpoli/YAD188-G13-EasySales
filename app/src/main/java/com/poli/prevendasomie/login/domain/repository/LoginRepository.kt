package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.ResponseTokenDto
import com.poli.prevendasomie.login.domain.model.Credentials

interface LoginRepository {

    suspend fun login(credentials: Credentials): Resource<ResponseTokenDto>
}
