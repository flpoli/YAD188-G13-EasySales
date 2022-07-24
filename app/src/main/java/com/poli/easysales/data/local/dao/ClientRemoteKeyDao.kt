package com.poli.easysales.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.easysales.common.Constants.CLIENT_KEY_TABLE
import com.poli.easysales.data.local.entities.clientes.ClientsRemoteKeys

@Dao
interface ClientRemoteKeyDao {

    @Query("SELECT * FROM $CLIENT_KEY_TABLE ORDER BY id ASC")
    suspend fun getRemoteKeys(): List<ClientsRemoteKeys>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(keys: List<ClientsRemoteKeys>)

    @Query("DELETE FROM $CLIENT_KEY_TABLE")
    suspend fun deleteAllRemoteKeys()
}
