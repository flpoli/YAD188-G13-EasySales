package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getSelectedClient(clientId: Int): ClientesCadastro
    fun getNonPaginatedClients(): Flow<List<ClientesCadastro>>

    suspend fun insertSelectedCliente(selectedClient: ClientesCadastro)
}
