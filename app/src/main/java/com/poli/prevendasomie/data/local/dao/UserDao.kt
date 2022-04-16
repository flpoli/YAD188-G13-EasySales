package com.poli.prevendasomie.data.local.dao

import androidx.room.*
import com.poli.prevendasomie.domain.model.UserDataModel
import com.poli.prevendasomie.signup.domain.model.UserData

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table WHERE username = :username")
    fun getUserByEmail(username: String): UserDataModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun persistUserData(userData: UserDataModel)

//    @Update()
//    fun updateUserAccessToken(token: ResponseTokenDto)
}