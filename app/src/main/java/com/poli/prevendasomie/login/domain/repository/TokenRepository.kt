package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.login.domain.model.Token
import kotlinx.coroutines.flow.Flow

interface TokenRepository {

    suspend fun storeToken(token: Token)
    suspend fun fetchToken(): Flow<String>
}
