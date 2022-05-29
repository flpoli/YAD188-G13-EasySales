package com.poli.prevendasomie.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.poli.prevendasomie.common.Constants.API_PAGE_SIZE
import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.data.local.entities.produtos.ProdutoEntity
import com.poli.prevendasomie.data.pagingsource.ClientsRemoteMediator
import com.poli.prevendasomie.data.pagingsource.OrdersRemoteMediator
import com.poli.prevendasomie.data.pagingsource.ProductsRemoteMediator
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import com.poli.prevendasomie.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl(
    private val api: OmieAPI,
    private val db: ErpDatabase
) : RemoteDataSource {

    private val productDao = db.productsDao()
    private val clientDao = db.clientDao()
    private val orderDao = db.ordersDao()

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllClients(): Flow<PagingData<ClientesCadastroEntity>> {

        val pagingSourceFactory = { clientDao.getAllClients() }
        val remoteMediator = ClientsRemoteMediator(api, db)
        return Pager(
            config = PagingConfig(
                pageSize = API_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = remoteMediator,
            pagingSourceFactory = pagingSourceFactory

        ).flow
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllProducts(): Flow<PagingData<ProdutoEntity>> {

        val pagingSourceFactory = { productDao.getAllProducts() }

        return Pager(
            config = PagingConfig(
                pageSize = API_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = ProductsRemoteMediator(
                api,
                db
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getAllOrders(): Flow<PagingData<PedidoVendaProduto>> {

        val pagingSourceFactory = { orderDao.getAllOrders() }

        return Pager(
            config = PagingConfig(
                pageSize = API_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = OrdersRemoteMediator(
                api,
                db,
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}
