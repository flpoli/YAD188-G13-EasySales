package com.poli.easysales.domain.repository

import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.local.entities.produtos.ProdutoVendaEntity
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getSelectedClient(clientId: Long): ClientesCadastroEntity

    fun getNonPaginatedClients(): Flow<List<ClientesCadastroEntity>>
    fun getProductsForSelection(): Flow<List<ProdutoVendaEntity>>
    suspend fun getSelectedProduct(productId: Long): ProdutoVendaEntity
    suspend fun getOrdersForClient(codigoClient: Long): List<PedidoVendaProduto>
    suspend fun getOrderById(orderId: Long): PedidoVendaProduto
    suspend fun insertNewOrder(order: PedidoVendaProduto)

}
