package com.poli.prevendasomie.login.domain.repository

import com.poli.prevendasomie.domain.repository.DataStoreOperations
import com.poli.prevendasomie.login.domain.model.Token
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class TokenRepositoryImpl
@Inject constructor(
    private val dataStore: DataStoreOperations,
) : TokenRepository {

    override suspend fun storeToken(token: Token) {

        println("Token que vai ser salvo: $token")

        dataStore.saveUserPref("TOKEN_KEY", token.authToken.value)
    }

    override suspend fun fetchToken(): Flow<String> {
        return dataStore.readUserPref("TOKEN_KEY")
    }
}
