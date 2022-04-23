package com.poli.prevendasomie.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.poli.prevendasomie.domain.model.clientes.ClientsRemoteKeys

@Dao
interface ClientRemoteKeyDao {

    @Query("SELECT * FROM clients_keys WHERE id = :id")
    fun getRemoteKeys(id: Int): ClientsRemoteKeys
}
