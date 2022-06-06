package com.poli.easysales.domain.repository

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.remote.Request
import com.poli.easysales.data.remote.dto.ReqResponse
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import kotlinx.coroutines.flow.Flow

interface ClientsRepository {

    fun getClientList(): Flow<PagingData<ClientesCadastroEntity>>
    fun getNonPaginatedClientList(): Flow<List<ClientesCadastroEntity>>
    suspend fun getSelectedClient(clientId: Long): ClientesCadastroEntity
    suspend fun addNewClient(request: Request.IncluirClienteRequest): ReqResponse
    suspend fun getOrdersForClient(codigoCliente: Long): List<PedidoVendaProduto>
}
