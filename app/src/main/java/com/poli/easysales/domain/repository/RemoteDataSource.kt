package com.poli.easysales.domain.repository

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.local.entities.produtos.ProdutoEntity
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllProducts(): Flow<PagingData<ProdutoEntity>>

    fun getAllClients(): Flow<PagingData<ClientesCadastroEntity>>

    fun getAllOrders(): Flow<PagingData<PedidoVendaProduto>>
}
