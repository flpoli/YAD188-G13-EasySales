package com.poli.prevendasomie.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poli.prevendasomie.common.Constants.CLIENTS_TABLE
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {

    @Query("SELECT * FROM $CLIENTS_TABLE")
    fun getAllClients(): PagingSource<Int, ClientesCadastroEntity>

    @Query("SELECT * FROM $CLIENTS_TABLE")
    fun getNonPaginatedClients(): Flow<List<ClientesCadastroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun persistClientList(cliente: List<ClientesCadastroEntity>)

    @Query("SELECT * FROM $CLIENTS_TABLE WHERE id = :id")
    suspend fun getClientById(id: Int): ClientesCadastroEntity

    @Query("DELETE FROM $CLIENTS_TABLE")
    suspend fun deleteAllClients()

    @Query("SELECT COUNT(ID) from $CLIENTS_TABLE")
    suspend fun getClientsCount(): Int
}
