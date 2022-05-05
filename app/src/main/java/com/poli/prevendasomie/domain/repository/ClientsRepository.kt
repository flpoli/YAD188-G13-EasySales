package com.poli.prevendasomie.domain.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ReqResponse
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import kotlinx.coroutines.flow.Flow

interface ClientsRepository {

    fun getClientList(): Flow<PagingData<ClientesCadastro>>?
    suspend fun getSelectedClient(clientId: Int): ClientesCadastro
    suspend fun addNewClient(request: Request.IncluirClienteRequest): ReqResponse
}
