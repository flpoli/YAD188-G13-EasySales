package com.poli.prevendasomie.domain.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ReqResponse
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import kotlinx.coroutines.flow.Flow

interface ClientsRepository {

    fun getClientList(): Flow<PagingData<ClientesCadastro>>?
    fun getNonPaginatedClientList(): Result<List<ClientesCadastroEntity>>
    suspend fun getSelectedClient(clientId: Int): ClientesCadastroEntity
    suspend fun addNewClient(request: Request.IncluirClienteRequest): ReqResponse
}
