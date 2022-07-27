package com.poli.easysales.domain.repository

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.local.entities.pedidos.PedidoVendaProdutoEntity
import com.poli.easysales.data.local.entities.produtos.ProdutoVendaEntity
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllProducts(): Flow<PagingData<ProdutoVendaEntity>>

    fun getAllClients(): Flow<PagingData<ClientesCadastroEntity>>

    fun getAllOrders(): Flow<PagingData<PedidoVendaProdutoEntity>>
}
