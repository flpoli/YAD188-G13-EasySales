package com.poli.prevendasomie.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

@Dao
interface ClientDao {

    @Query("SELECT * FROM clients_table")
    fun getAllClients(): PagingSource<Int, ClientesCadastro>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistClientList(cliente: List<ClientesCadastro>)

    @Query("SELECT * FROM clients_table WHERE id = :id")
    suspend fun getClientById(id: Int): ClientesCadastro

    @Query("DELETE FROM clients_table")
    suspend fun deleteAllClients()

    @Query("SELECT COUNT(ID) from clients_table")
    suspend fun getClientsCount(): Int
}
