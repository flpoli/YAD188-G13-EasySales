package com.poli.prevendasomie.data.local.dao

import androidx.room.*
import com.poli.prevendasomie.domain.model.UserDataModel

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table WHERE email = :email")
    fun getUserByEmail(email: String): UserDataModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun persistUserData(userData: UserDataModel)

//    @Update()
//    fun updateUserAccessToken(token: String)
}
