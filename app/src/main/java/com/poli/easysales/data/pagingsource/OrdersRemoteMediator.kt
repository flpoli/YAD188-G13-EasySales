package com.poli.easysales.data.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.poli.easysales.common.Constants.CACHE_TIMEOUT
import com.poli.easysales.data.local.ErpDatabase
import com.poli.easysales.data.local.entities.pedidos.OrdersRemoteKeys
import com.poli.easysales.data.local.entities.pedidos.PedidoVendaProdutoEntity
import com.poli.easysales.data.remote.OmieAPI
import com.poli.easysales.data.remote.Param
import com.poli.easysales.data.remote.Request
import com.poli.easysales.data.remote.dto.pedidos.toPedidoVendaProduto
import com.poli.easysales.domain.mappers.toPedidoEntity
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import java.lang.Exception
import javax.inject.Inject

@ExperimentalPagingApi
class OrdersRemoteMediator
@Inject constructor(
    private val api: OmieAPI,
    private val db: ErpDatabase
) : RemoteMediator<Int, PedidoVendaProdutoEntity>() {

    private val orderDao = db.ordersDao()
    private val remoteKeysDao = db.ordersRemoteKeysDao()

    override suspend fun initialize(): InitializeAction {

        val currentTime = System.currentTimeMillis()
        val lastUpdated = remoteKeysDao.getRemoteKeys().firstOrNull()?.lastUpdated ?: 0L
        val diffInMinutes = (currentTime - lastUpdated) / 1000 / 60

        return if (diffInMinutes.toInt() <= CACHE_TIMEOUT) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, PedidoVendaProdutoEntity>
    ): MediatorResult {

        try {

            val page = when (loadType) {

                LoadType.REFRESH -> {

                    if (orderDao.getOrdersCount() > 0) {

                        return MediatorResult.Success(endOfPaginationReached = true)
                    } else {

                        val initialPage = 1
                        initialPage
                    }
                }
                LoadType.PREPEND -> {
                    return MediatorResult.Success(endOfPaginationReached = true)
                }
                LoadType.APPEND -> {

                    val lastRemoteKey = getLastRemoteKey()

                    if (lastRemoteKey?.nextPage != null) {
                        lastRemoteKey.nextPage
                    } else {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }
                }
            }

            val request = Request.ListarPedidosRequest(
                param = listOf(
                    Param.ParamListarPedidos(
                        pagina = page.toString(),
                        registrosPorPagina = state.config.pageSize.toString()
                    )
                )
            )
            val response = api.getOrderList(request)

            if (response.pedidoVendaProduto.isNotEmpty()) {
                db.withTransaction {
                    if (loadType == LoadType.REFRESH) {
                        orderDao.deleteAllOrders()
                        remoteKeysDao.deleteAllRemoteKeys()
                    }
                    val prevPage = response.pagina.minus(1)
                    val nextPage = response.pagina.plus(1)

                    val keys = response.pedidoVendaProduto.map {

                            pedido ->
                        OrdersRemoteKeys(

                            prevPage = prevPage,
                            nextPage = nextPage,
                            lastUpdated = System.currentTimeMillis()

                        )
                    }

                    val pedido = response.pedidoVendaProduto.map {
                        it
                            .toPedidoVendaProduto()
                            .toPedidoEntity()
                    }

                    remoteKeysDao.addAllRemoteKeys(keys)
                    orderDao.persistOrderList(pedido)
                }
            }
            return MediatorResult.Success(endOfPaginationReached = response.pagina == response.totalDePaginas)
        } catch (e: Exception) {
            e.printStackTrace()
            return MediatorResult.Error(e)
        }
    }
    private suspend fun getLastRemoteKey(): OrdersRemoteKeys? {

        return remoteKeysDao.getRemoteKeys().lastOrNull()
    }
}
