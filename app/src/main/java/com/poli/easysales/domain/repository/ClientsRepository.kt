package com.poli.easysales.domain.repository

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.remote.Request
import com.poli.easysales.data.remote.dto.CepResponse
import com.poli.easysales.data.remote.dto.ReqResponse
import com.poli.easysales.data.remote.dto.clientes.CaracteristicasDto
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ClientsRepository {

    fun getClientList(): Flow<PagingData<ClientesCadastroEntity>>
    fun getNonPaginatedClientList(): Flow<List<ClientesCadastroEntity>>
    suspend fun getSelectedClient(clientId: Long): ClientesCadastroEntity
    suspend fun getClientCarac(codigoCliente: Long): CaracteristicasDto?
    suspend fun addNewClient(request: Request.IncluirClienteRequest): ReqResponse
    suspend fun getOrdersForClient(codigoCliente: Long): List<PedidoVendaProduto>
    suspend fun getAddressByCep(cep: String): Response<CepResponse>
}
