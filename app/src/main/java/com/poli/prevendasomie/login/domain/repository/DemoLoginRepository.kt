package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.login.domain.model.*
import com.poli.prevendasomie.data.Result
import javax.inject.Inject

class DemoLoginRepository @Inject constructor() : LoginRepository {

    override suspend fun login(credentials: Credentials): Result<LoginResponse> {
        val defaultToken = Token(
            AuthToken(""),
            RefreshToken(""),
        )

        val defaultResponse = LoginResponse(defaultToken)

        return Result.Success(defaultResponse)
    }
}