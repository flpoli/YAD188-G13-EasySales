package com.poli.easysales.domain.repository

import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.local.entities.produtos.ProdutoEntity
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getSelectedClient(clientId: Long): ClientesCadastroEntity

    fun getNonPaginatedClients(): Flow<List<ClientesCadastroEntity>>
    fun getProductsForSelection(): Flow<List<ProdutoEntity>>
    suspend fun getSelectedProduct(productId: Long): ProdutoEntity
    suspend fun insertSelectedCliente(selectedClient: ClientesCadastroEntity)

    suspend fun getOrderById(orderId: Long): PedidoVendaProduto
}
