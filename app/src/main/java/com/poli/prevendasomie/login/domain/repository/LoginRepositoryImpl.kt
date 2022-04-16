package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.BackEndApi
import com.poli.prevendasomie.data.remote.ResponseTokenDto
import com.poli.prevendasomie.login.domain.model.Credentials
import retrofit2.Response
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: BackEndApi
) : LoginRepository {
     override suspend fun login(credentials: Credentials): Resource<Response<Unit>> {

        val call = api.executeLogin(credentials)

//        when (call) {
//            is Resource.Success<> -> {
//
//
//                println(call)
//            }
//            is Resource.Error -> {
//                println(call)
//            }
//        }

        return Resource.Success(call)

    }
}
