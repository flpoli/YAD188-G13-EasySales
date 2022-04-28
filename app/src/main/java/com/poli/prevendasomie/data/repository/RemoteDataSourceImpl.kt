
package com.poli.prevendasomie.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.poli.prevendasomie.common.Constants.API_PAGE_SIZE
import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.data.local.entities.pedidos.PedidoVendaEntity
import com.poli.prevendasomie.data.pagingsource.ClientsRemoteMediator
import com.poli.prevendasomie.data.pagingsource.OrdersRemoteMediator
import com.poli.prevendasomie.data.pagingsource.ProductsRemoteMediator
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val api: OmieAPI,
    private val db: ErpDatabase
) : RemoteDataSource {

    private val productDao = db.productsDao()
    private val clientDao = db.clientDao()
    private val orderDao = db.ordersDao()

    override fun getAllProducts(): Flow<PagingData<ProdutoServicoCadastro>> {

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

    override fun getAllClients(): Flow<PagingData<ClientesCadastro>> {

        val pagingSourceFactory = { clientDao.getAllClients() }

        return Pager(
            config = PagingConfig(
                pageSize = API_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = ClientsRemoteMediator(
                api,
                db
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun getAllOrders(): Flow<PagingData<PedidoVendaEntity>> {

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
