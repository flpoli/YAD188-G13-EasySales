package com.poli.prevendasomie.domain.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.data.pagingsource.ClientsRemoteMediator
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllProducts(): Flow<PagingData<ProdutoServicoCadastro>>

    fun getAllClients(): Flow<PagingData<ClientesCadastro>>

    fun getAllOrders(): Flow<PagingData<PedidoVendaProduto>>
    @OptIn(ExperimentalPagingApi::class)
    fun Pager(
        config: PagingConfig,
        remoteMediator: ClientsRemoteMediator,
        pagingSourceFactory: PagingSource<Int, ClientesCadastroEntity>
    ): Flow<PagingData<ClientesCadastro>>
}
