package com.poli.prevendasomie.login.domain.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.poli.prevendasomie.login.domain.model.Token
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class DemoTokenRepository
@Inject constructor(
    private val context: Context,
    // private val dataStore: DataStoreOperations,

) : TokenRepository {

    companion object {

        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("tokenKey")
        val TOKEN_KEY = stringPreferencesKey("TOKEN_KEY")
    }

    override suspend fun storeToken(token: Token) {

        val tokenKey = stringPreferencesKey("TOKEN_KEY")

        context.dataStore.edit { pref ->
            pref[tokenKey] = token.authToken.value
        }
    }

    override suspend fun fetchToken(): Token? {

//        val tokenKey = stringPreferencesKey("TOKEN_KEY")
//
//        dataStore.readUserKey()
//        val getToken = context.dataStore.data
//            .map { pref ->
//                pref[tokenKey] ?: ""
//            }
// //            .collect {
// //                 Token(
// //                    authToken = AuthToken(it),
// //                    tokenExpiry = TokenExpiry("864000000"),
// //                    tokenType = TokenType("Authorization")
// //                )
// //            }
//
//
//
//
        //         return

        return null
    }
}
