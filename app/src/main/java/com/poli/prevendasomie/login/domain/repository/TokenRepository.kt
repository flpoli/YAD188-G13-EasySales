package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.login.domain.model.Token

interface TokenRepository {

    suspend fun storeToken(token: Token)
    suspend fun fetchToken(): Token?
}