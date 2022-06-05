package com.poli.easysales.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.easysales.common.Constants.CLIENTS_TABLE
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {

    @Query("SELECT * FROM $CLIENTS_TABLE")
    fun getAllClients(): PagingSource<Int, ClientesCadastroEntity>

    @Query("SELECT * FROM $CLIENTS_TABLE")
    fun getNonPaginatedClients(): Flow<List<ClientesCadastroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistClientList(cliente: List<ClientesCadastroEntity>)

    @Query("SELECT * FROM $CLIENTS_TABLE WHERE codClienteOmie = :id")
    suspend fun getClientById(id: Long): ClientesCadastroEntity

    @Query("DELETE FROM $CLIENTS_TABLE")
    suspend fun deleteAllClients()

    @Query("SELECT COUNT(ID) from $CLIENTS_TABLE")
    suspend fun getClientsCount(): Int
}
