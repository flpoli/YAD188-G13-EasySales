package com.poli.prevendasomie.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {

    suspend fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>


    suspend fun saveUserPref(key: String, value: String)
    fun readUserPref(key: String): Flow<String>
}
