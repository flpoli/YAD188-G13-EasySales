package com.poli.prevendasomie.data.local.dao

import androidx.room.*
import com.poli.prevendasomie.domain.model.UserDataModel

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table WHERE username = :username")
    fun getUserByEmail(username: String): UserDataModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistUserData(userData: UserDataModel)

    @Query("SELECT * FROM user_table")
    suspend fun selectAllInfo(): UserDataModel
}


