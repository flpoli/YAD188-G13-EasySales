package com.poli.prevendasomie.domain.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ReqResponse
import kotlinx.coroutines.flow.Flow

interface ClientsRepository {

    fun getClientList(): Flow<PagingData<ClientesCadastroEntity>>
    fun getNonPaginatedClientList(): Flow<List<ClientesCadastroEntity>>
    suspend fun getSelectedClient(clientId: Long): ClientesCadastroEntity
    suspend fun addNewClient(request: Request.IncluirClienteRequest): ReqResponse
}
