package com.poli.prevendasomie.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.common.Constants.CLIENT_KEY_TABLE
import com.poli.prevendasomie.data.local.entities.ClientsRemoteKeys

@Dao
interface ClientRemoteKeyDao {

    @Query("SELECT * FROM $CLIENT_KEY_TABLE ORDER BY id ASC")
    suspend fun getRemoteKeys(): List<ClientsRemoteKeys>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(keys: List<ClientsRemoteKeys>)

    @Query("DELETE FROM $CLIENT_KEY_TABLE")
    suspend fun deleteAllRemoteKeys()
}
