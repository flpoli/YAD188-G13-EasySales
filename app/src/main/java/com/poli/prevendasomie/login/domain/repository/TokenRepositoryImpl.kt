package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.domain.repository.Preferences
import com.poli.prevendasomie.login.domain.model.Token
import com.poli.prevendasomie.signup.domain.model.UserData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TokenRepositoryImpl
@Inject constructor(
    private val dataStore: Preferences,
) : TokenRepository {

    override suspend fun storeToken(token: Token) {

        println("Token que vai ser salvo: $token")

        //dataStore.saveUserPref("TOKEN_KEY", token.authToken.value)


    }

    override suspend fun fetchToken(): UserData {
      return dataStore.readUserSession()

    }
}
