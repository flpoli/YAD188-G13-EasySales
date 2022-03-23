package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.data.Result
import com.poli.prevendasomie.data.remote.BackEndApi
import com.poli.prevendasomie.login.domain.model.Credentials
import com.poli.prevendasomie.login.domain.model.LoginResponse
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: BackEndApi
): LoginRepository {
    override suspend fun login(credentials: Credentials): Result<LoginResponse> {

        val call =  api.executeLogin(credentials)

        when(call) {
            is Result.Success -> {
                println(call)}
            is Result.Error -> {
                println(call)
            }
        }
        return call


    }
}