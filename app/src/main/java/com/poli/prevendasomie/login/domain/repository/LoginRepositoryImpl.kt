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

        val chamada =  api.executeLogin(credentials)

        when(chamada) {
            is Result.Success -> {
                println(chamada)}
            is Result.Error -> {
                println(chamada)
            }
        }
        return chamada


    }
}