package com.poli.prevendasomie.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.poli.prevendasomie.data.local.dao.UserDao
import com.poli.prevendasomie.data.util.GsonParser
import com.poli.prevendasomie.domain.model.UserDataModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class UserDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ErpDatabase
    private lateinit var dao: UserDao

    @Before
    fun setup() {

        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ErpDatabase::class.java
        )
            .allowMainThreadQueries()
            .addTypeConverter(DatabaseConverter(GsonParser(Gson())))
            .build()

        dao = database.userDao()
    }
    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertUser() = runBlockingTest {

        val user = UserDataModel(
            id = 1,
            email = "example@example.com",
            username = "example username",
            appKey = "TESTEAPPKEY",
            appSecret = "TESTAPPSECRET",
            accessToken = "TESTEACCESSTOKEN"

        )
        dao.persistUserData(user)

        val getUser = dao.selectAllInfo()

        assertThat(getUser == user)
    }
}
