package com.poli.easysales.domain.repository

import androidx.paging.PagingData
import com.poli.easysales.data.remote.Request
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {

    fun getOrderList(): Flow<PagingData<PedidoVendaProduto>>
    suspend fun getOrderById(orderId: Long): PedidoVendaProduto
    suspend fun insertSelectedClient(selectedClient: ClientesCadastro)
     fun insertNewOrder(request: Request.IncluirPedidosRequest)

    //db operations for create new orders

    suspend fun addClientOnOrder(orderId: Int, codigoCliente: Long)


}
