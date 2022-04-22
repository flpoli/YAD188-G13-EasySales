package com.poli.prevendasomie.data.local.dao

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ClientDao {

    @Insert
    suspend fun persistClientData()
}