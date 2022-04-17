package com.poli.prevendasomie.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class DataStoreOperationsImplTest : CourotineTest() {

    private lateinit var preferencesScope: CoroutineScope
    private lateinit var dataStore: DataStore<Preferences>

    @Before
    fun setUp() {

        preferencesScope = CoroutineScope(testDispatcher + Job())
    }

    @After
    fun tearDown() {
    }

    @Test
    fun saveOnBoardingState() {
    }

    @Test
    fun readOnBoardingState() {
    }

    @Test
    fun saveUserKey() {
    }

    @Test
    fun saveTokenKey() {
    }

    @Test
    fun saveAppKey() {
    }

    @Test
    fun saveAppSecret() {
    }

    @Test
    fun readUserKey() {
    }

    @Test
    fun readTokenKey() {
    }

    @Test
    fun readAppKey() {
    }

    @Test
    fun readAppSecret() {
    }
}
