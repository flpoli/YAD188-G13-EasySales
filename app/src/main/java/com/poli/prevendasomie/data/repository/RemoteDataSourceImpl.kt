
package com.poli.prevendasomie.data.repository

import android.util.Log
import android.util.Log.DEBUG
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.poli.prevendasomie.common.Constants.API_PAGE_SIZE
import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.data.pagingsource.ClientsRemoteMediator
import com.poli.prevendasomie.data.pagingsource.OrdersRemoteMediator
import com.poli.prevendasomie.data.pagingsource.ProductsRemoteMediator
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

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

        val pagingSourceFactory = clientDao.getAllClients()

        pagingSourceFactory.jumpingSupported

        return this.Pager(
            config = PagingConfig(
                pageSize = API_PAGE_SIZE,
                enablePlaceholders = false
            ),
            remoteMediator = ClientsRemoteMediator(
                api,
                db
            ),
            pagingSourceFactory = pagingSourceFactory

        )

        Log.d("Remote Data Source - Pager", "")


    }

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

    override fun Pager(
        config: PagingConfig,
        remoteMediator: ClientsRemoteMediator,
        pagingSourceFactory: PagingSource<Int, ClientesCadastroEntity>
    ): Flow<PagingData<ClientesCadastro>> {

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

        )
    }
}
