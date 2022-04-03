package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.data.Result
import com.poli.prevendasomie.login.domain.model.AuthToken
import com.poli.prevendasomie.login.domain.model.Credentials
import com.poli.prevendasomie.login.domain.model.LoginResponse
import com.poli.prevendasomie.login.domain.model.RefreshToken
import com.poli.prevendasomie.login.domain.model.Token
import javax.inject.Inject

class DemoLoginRepository @Inject constructor()
// : LoginRepository {
//
//    override suspend fun login(credentials: Credentials): Result<LoginResponse> {
//        val defaultToken = Token(
//            AuthToken(""),
//            RefreshToken(""),
//        )
//
//        val defaultResponse = LoginResponse(defaultToken)
//
//        return Result.Success(defaultResponse)
//    }
//}
