package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getSelectedClient(clientId: Long): ClientesCadastroEntity
    fun getNonPaginatedClients(): Flow<List<ClientesCadastroEntity>>

    suspend fun insertSelectedCliente(selectedClient: ClientesCadastroEntity)
}
