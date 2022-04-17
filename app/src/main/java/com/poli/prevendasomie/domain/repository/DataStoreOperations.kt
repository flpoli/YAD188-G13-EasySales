package com.poli.prevendasomie.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {

    suspend fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>

    suspend fun saveUserKey(user: String)
    suspend fun saveTokenKey(token: String)

    fun readUserKey(): Flow<String>
    fun readTokenKey(): Flow<String>

    suspend fun saveAppKey(appKey: String)
    suspend fun saveAppSecret(appSecret: String)

    fun readAppKey(): Flow<String>
    fun readAppSecret(): Flow<String>

    suspend fun saveUserPref(key: String, value: String)
    fun readUserPref(key: String): Flow<String>
}
