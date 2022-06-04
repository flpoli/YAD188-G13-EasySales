package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.login.domain.model.Token
import com.poli.prevendasomie.signup.domain.model.UserData
import kotlinx.coroutines.flow.Flow

interface TokenRepository {

    suspend fun storeToken(token: Token)
    suspend fun fetchToken(): UserData
}
