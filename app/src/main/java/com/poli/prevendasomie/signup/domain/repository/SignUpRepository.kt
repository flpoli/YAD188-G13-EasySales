package com.poli.prevendasomie.signup.domain.repository

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.responses.ResponseSignUpDto
import com.poli.prevendasomie.signup.domain.model.UserData

interface SignUpRepository {

    suspend fun signUp(userData: UserData): Resource<ResponseSignUpDto>
}
