package com.poli.prevendasomie.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.data.local.entities.ClientsRemoteKeys

@Dao
interface ClientRemoteKeyDao {

    @Query("SELECT * FROM clients_keys ORDER BY id ASC")
    suspend fun getRemoteKeys(): List<ClientsRemoteKeys>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(keys: List<ClientsRemoteKeys>)

    @Query("DELETE FROM clients_keys")
    suspend fun deleteAllRemoteKeys()
}
