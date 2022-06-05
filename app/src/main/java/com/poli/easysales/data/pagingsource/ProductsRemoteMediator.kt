package com.poli.easysales.data.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.poli.easysales.common.Constants.CACHE_TIMEOUT
import com.poli.easysales.data.local.ErpDatabase
import com.poli.easysales.data.local.entities.ProductsRemoteKeys
import com.poli.easysales.data.local.entities.produtos.ProdutoEntity
import com.poli.easysales.data.remote.OmieAPI
import com.poli.easysales.data.remote.Param
import com.poli.easysales.data.remote.Request
import com.poli.easysales.domain.mappers.toProdutoCadastro
import com.poli.easysales.domain.mappers.toProdutoEntity
import javax.inject.Inject

@ExperimentalPagingApi
class ProductsRemoteMediator
@Inject constructor(
    private val api: OmieAPI,
    private val db: ErpDatabase
) : RemoteMediator<Int, ProdutoEntity>() {

    private val productDao = db.productsDao()
    private val remoteKeysDao = db.productRemoteKeysDao()

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
        state: PagingState<Int, ProdutoEntity>
    ): MediatorResult {

        try {

            val page = when (loadType) {

                LoadType.REFRESH -> {

                    if (productDao.getProductsCount() > 0) {

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

            val request = Request.ListarProdutosRequest(
                param = listOf(
                    Param.ParamListarProdutos(
                        pagina = page.toString(),
                        registrosPorPagina = state.config.pageSize.toString()

                    )
                )
            )

            val response = api.getProductList(request)
            if (response.produtoServicoCadastro.isNotEmpty()) {

                db.withTransaction {

                    if (loadType == LoadType.REFRESH) {
                        productDao.deleteAllProducts()
                        remoteKeysDao.deleteAllRemoteKeys()
                    }

                    val prevPage = response.pagina.minus(1)
                    val nextPage = response.pagina.plus(1)

                    val keys = response.produtoServicoCadastro.map {

                        ProductsRemoteKeys(
                            prevPage = prevPage,
                            nextPage = nextPage,
                            lastUpdated = System.currentTimeMillis()
                        )
                    }

                    response.produtoServicoCadastro.map { if (it.imagens == null) { it.imagens = emptyList() } }

                    val prod = response.produtoServicoCadastro.map {

                        it
                            .toProdutoCadastro()
                            .toProdutoEntity()
                    }

                    remoteKeysDao.addAllRemoteKeys(keys)
                    productDao.persistProductList(prod)
                }
            }
            return MediatorResult.Success(endOfPaginationReached = response.pagina == response.totalDePaginas)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getLastRemoteKey(): ProductsRemoteKeys? {

        return remoteKeysDao.getRemoteKeys().lastOrNull()
    }
}
