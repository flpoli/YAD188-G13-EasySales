package com.poli.prevendasomie.domain.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.data.local.entities.produtos.ProdutoEntity
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllProducts(): Flow<PagingData<ProdutoEntity>>

    fun getAllClients(): Flow<PagingData<ClientesCadastroEntity>>

    fun getAllOrders(): Flow<PagingData<PedidoVendaProduto>>
}
