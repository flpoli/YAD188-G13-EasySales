package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.data.Result
import com.poli.prevendasomie.login.domain.model.Credentials
import com.poli.prevendasomie.login.domain.model.LoginResponse

interface LoginRepository {

    suspend fun login(credentials: Credentials): Result<LoginResponse>
}
