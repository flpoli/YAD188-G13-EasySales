package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getSelectedClient(clientId: Long): ClientesCadastroEntity

    fun getNonPaginatedClients(): Flow<List<ClientesCadastroEntity>>
    fun getProductsForSelection(): Flow<List<ProdutoServicoCadastro>>
    suspend fun getSelectedProduct(productId: Long): ProdutoServicoCadastro
    suspend fun insertSelectedCliente(selectedClient: ClientesCadastroEntity)

    suspend fun getOrderById(orderId: Long): PedidoVendaProduto
}
