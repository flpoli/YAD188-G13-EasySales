package com.poli.prevendasomie.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {

    @Query("SELECT * FROM clients_table")
    fun getAllClients(): PagingSource<Int, ClientesCadastroEntity>

    @Query("SELECT * FROM clients_table")
    fun getNonPaginatedClients(): Flow<List<ClientesCadastroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistClientList(cliente: List<ClientesCadastro>)

    @Query("SELECT * FROM clients_table WHERE id = :id")
    suspend fun getClientById(id: Int): ClientesCadastroEntity

    @Query("DELETE FROM clients_table")
    suspend fun deleteAllClients()

    @Query("SELECT COUNT(ID) from clients_table")
    suspend fun getClientsCount(): Int
}
