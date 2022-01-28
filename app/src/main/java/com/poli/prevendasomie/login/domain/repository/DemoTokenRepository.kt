package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.login.domain.model.Token
import javax.inject.Inject

class DemoTokenRepository @Inject constructor() : TokenRepository {
    override suspend fun storeToken(token: Token) {
        // No-Op
    }

    override suspend fun fetchToken(): Token? {
        return null
    }
}
