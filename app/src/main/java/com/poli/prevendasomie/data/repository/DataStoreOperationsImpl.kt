package com.poli.prevendasomie.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.poli.prevendasomie.common.Constants.PREFERENCES_KEY
import com.poli.prevendasomie.common.Constants.PREFERENCES_NAME
import com.poli.prevendasomie.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_NAME)

class DataStoreOperationsImpl(context: Context) : DataStoreOperations {

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = PREFERENCES_KEY)
        val userKey = stringPreferencesKey(name = PREFERENCES_KEY)
        val tokenKey = stringPreferencesKey(name = "TOKEN_KEY")
        val appKeyKey = stringPreferencesKey(name = "APP_KEY") // LOL
        val appSecretKey = stringPreferencesKey(name = "APP_SECRET")

        //val userPrefKey = stringPreferencesKey(name)
    }

    private val dataStore = context.dataStore

    override suspend fun saveOnBoardingState(completed: Boolean) {

        dataStore.edit {

                preferences ->
            preferences[PreferencesKey.onBoardingKey] = completed
        }
    }

    override fun readOnBoardingState(): Flow<Boolean> {

        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map {
                    preferences ->
                val onBoardingState = preferences[PreferencesKey.onBoardingKey] ?: false
                onBoardingState
            }
    }

    override suspend fun saveUserKey(user: String) {
        dataStore.edit {
                pref ->
            pref[PreferencesKey.userKey] = user
        }
    }
    override suspend fun saveTokenKey(token: String) {
        dataStore.edit {
                pref ->
            pref[PreferencesKey.tokenKey] = token
        }
    }
    override suspend fun saveAppKey(appKey: String) {
        dataStore.edit {
                pref ->
            pref[PreferencesKey.appKeyKey] = appKey
        }
    }
    override suspend fun saveAppSecret(appSecret: String) {
        dataStore.edit {
                pref ->
            pref[PreferencesKey.appSecretKey] = appSecret
        }
    }

    override fun readUserKey(): Flow<String> {

        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map {

                    pref -> pref[PreferencesKey.userKey] ?: ""


            }
    }
    override fun readTokenKey(): Flow<String> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map {

                    pref ->
                val tokenKeyState = pref[PreferencesKey.tokenKey] ?: ""

                tokenKeyState
            }
    }
    override fun readAppKey(): Flow<String> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map {

                    pref -> pref[PreferencesKey.appKeyKey] ?: ""


            }
    }

    override fun readAppSecret(): Flow<String> {

        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map {

                    pref ->
                val appSecretKeyState = pref[PreferencesKey.appSecretKey] ?: ""

                appSecretKeyState
            }
    }

    override suspend fun saveUserPref(key: String, value: String) {

        val userPrefKey = stringPreferencesKey(key)

        dataStore.edit {
            preferences -> preferences[userPrefKey] = value
        }
    }

    override fun readUserPref(key: String): Flow<String> {

        val userPrefKey = stringPreferencesKey(key)

        return dataStore.data
            .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
            .map {
                    preferences -> val userPreferences = preferences[userPrefKey] ?: ""

                    userPreferences
            }
    }
}
