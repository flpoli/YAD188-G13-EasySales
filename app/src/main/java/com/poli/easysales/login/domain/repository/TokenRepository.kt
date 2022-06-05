package com.poli.easysales.login.domain.repository

import com.poli.easysales.login.domain.model.Token
import com.poli.easysales.signup.domain.model.UserData

interface TokenRepository {

    suspend fun storeToken(token: Token)
    suspend fun fetchToken(): UserData
}
