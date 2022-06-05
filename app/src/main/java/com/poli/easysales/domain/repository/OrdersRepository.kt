package com.poli.easysales.domain.repository

import androidx.paging.PagingData
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {

    fun getOrderList(): Flow<PagingData<PedidoVendaProduto>>
    suspend fun getOrderById(orderId: Long): PedidoVendaProduto
    suspend fun insertSelectedClient(selectedClient: ClientesCadastro)
}
