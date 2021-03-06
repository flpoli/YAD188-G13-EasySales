package com.poli.prevendasomie.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.common.Constants.USER_TABLE
import com.poli.prevendasomie.domain.model.UserDataModel

@Dao
interface UserDao {

    @Query("SELECT * FROM $USER_TABLE WHERE username = :username")
    fun getUserByEmail(username: String): UserDataModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistUserData(userData: UserDataModel)

    @Query("SELECT * FROM $USER_TABLE")
    suspend fun selectAllInfo(): UserDataModel
}
