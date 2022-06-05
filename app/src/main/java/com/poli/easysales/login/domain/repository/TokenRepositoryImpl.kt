package com.poli.easysales.login.domain.repository

import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.login.domain.model.Token
import com.poli.easysales.signup.domain.model.UserData
import javax.inject.Inject

class TokenRepositoryImpl
@Inject constructor(
    private val dataStore: Preferences,
) : TokenRepository {

    override suspend fun storeToken(token: Token) {

        println("Token que vai ser salvo: $token")

        // dataStore.saveUserPref("TOKEN_KEY", token.authToken.value)
    }

    override suspend fun fetchToken(): UserData {
        return dataStore.readUserSession()
    }
}
