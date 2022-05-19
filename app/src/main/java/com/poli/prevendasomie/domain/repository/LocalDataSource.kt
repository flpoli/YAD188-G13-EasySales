package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getSelectedClient(clientId: Int): ClientesCadastroEntity
    fun getNonPaginatedClients(): Result<List<ClientesCadastroEntity>>

    suspend fun insertSelectedCliente(selectedClient: ClientesCadastroEntity)
}
