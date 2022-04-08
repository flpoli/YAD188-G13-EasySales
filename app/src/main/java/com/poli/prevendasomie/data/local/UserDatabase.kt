package com.poli.prevendasomie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.poli.prevendasomie.data.local.dao.UserDao
import com.poli.prevendasomie.domain.model.UserDataModel

@Database(
    entities = [UserDataModel::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}
