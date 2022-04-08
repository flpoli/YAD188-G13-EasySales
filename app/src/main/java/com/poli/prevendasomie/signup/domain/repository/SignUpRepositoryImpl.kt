package com.poli.prevendasomie.signup.domain.repository

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.BackEndApi
import com.poli.prevendasomie.data.remote.responses.ResponseSignUpDto
import com.poli.prevendasomie.signup.domain.model.UserData
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val api: BackEndApi
) : SignUpRepository {

    override suspend fun signUp(userData: UserData): Resource<ResponseSignUpDto> {

        val call = api.userRegistration(userData)

        return Resource.Success(call)
    }
}
