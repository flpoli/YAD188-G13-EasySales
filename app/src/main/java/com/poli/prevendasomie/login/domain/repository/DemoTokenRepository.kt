package com.poli.prevendasomie.login.domain.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.poli.prevendasomie.domain.repository.DataStoreOperations
import com.poli.prevendasomie.login.domain.model.Token
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class DemoTokenRepository
@Inject constructor(
    //private val context: Context,
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
