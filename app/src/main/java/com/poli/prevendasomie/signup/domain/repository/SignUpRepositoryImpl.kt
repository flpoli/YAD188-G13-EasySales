package com.poli.prevendasomie.signup.domain.repository

import com.poli.prevendasomie.data.Result
import com.poli.prevendasomie.data.remote.BackEndApi
import com.poli.prevendasomie.signup.domain.model.SignUpResponse
import com.poli.prevendasomie.signup.domain.model.UserData
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val api: BackEndApi
    ): SignUpRepository {

    override suspend fun signUp(userData: UserData): Result<SignUpResponse> {

        val call = api.userRegistration(userData)

        when (call) {

            is Result.Success -> {
                println(call)}

            }

//            is Result.Error -> {
//
//            }

        return call


    }


}
