package com.poli.prevendasomie.data.pagingsource

import android.util.Log
import android.util.Log.DEBUG
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.produtos.toProdutoCadastro
import com.poli.prevendasomie.domain.model.produtos.ProductsRemoteKeys
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import javax.inject.Inject

@ExperimentalPagingApi
class ProductsRemoteMediator
@Inject constructor(
    private val api: OmieAPI,
    private val db: ErpDatabase
) : RemoteMediator<Int, ProdutoServicoCadastro>() {

    private val productDao = db.productsDao()
    private val remoteKeysDao = db.productRemoteKeysDao()

//    override suspend fun initialize(): InitializeAction {
//
//        val currentTime = System.currentTimeMillis()
//        val lastUpdated = remoteKeysDao.getRemoteKeys(id = 1)?.lastUpdated ?: 0L
//        val cacheTimeout = 1440
//        val diffInMinutes = (currentTime - lastUpdated) / 1000 / 60
//
//        return if (diffInMinutes.toInt() <= cacheTimeout) {
//            InitializeAction.SKIP_INITIAL_REFRESH
//        } else {
//            InitializeAction.LAUNCH_INITIAL_REFRESH
//        }
//    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ProdutoServicoCadastro>
    ): MediatorResult {

        try {

            val page = when (loadType) {

                LoadType.REFRESH -> {

//                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
//                    remoteKeys?.nextPage?.minus(1) ?: 1

                        if(productDao.getProductsCount() > 0){

                            return MediatorResult.Success(endOfPaginationReached = true)

                        }else {
                            val initialPage = 0
                            initialPage
                        }

                }
                LoadType.PREPEND -> {

//                    val remoteKeys = getRemoteKeyForFirstItem(state)
//                    val prevPage = remoteKeys?.prevPage
//                        ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
//                    prevPage

                    return MediatorResult.Success(endOfPaginationReached = true)


                }
                LoadType.APPEND -> {

//                    val remoteKeys = getRemoteKeyForLastItem(state)
//                    val nextPage = remoteKeys?.nextPage
//                        ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
//                    nextPage.plus(1)

                    val lastRemoteKey = getLastRemoteKey()

                    if(lastRemoteKey?.nextPage != null){
                        lastRemoteKey.nextPage
                    }else {
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

                Log.d("PAGE?", page.toString())
                Log.d("state.pages?", state.pages.toString())
                db.withTransaction {

                    if (loadType == LoadType.REFRESH) {

                        productDao.deleteAllProducts()
                        remoteKeysDao.deleteAllRemoteKeys()
                    }

                    val prevPage = response.pagina.minus(1)
                    val nextPage = response.pagina.plus(1)
                    val keys = response.produtoServicoCadastro.map {

                            produto ->

                                ProductsRemoteKeys(
                                    id = produto.id,
                                    prevPage = prevPage,
                                    nextPage = nextPage,
                                    lastUpdated = System.currentTimeMillis()
                                )
                    }

                    val prod = response.produtoServicoCadastro.map { it.toProdutoCadastro() }

                    remoteKeysDao.addAllRemoteKeys(keys)
                    productDao.persistProductList(prod)
                }
            }
            return MediatorResult.Success(endOfPaginationReached = response.pagina == null)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getLastRemoteKey(): ProductsRemoteKeys? {

        return remoteKeysDao.getRemoteKeys().lastOrNull()

    }

//    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, ProdutoServicoCadastro>): ProductsRemoteKeys? {
//
//        return state.anchorPosition?.let { position ->
//            state.closestItemToPosition(position)?.key?.let { id ->
//
//                remoteKeysDao.getRemoteKeys(id = id)
//            }
//        }
//    }
//
//    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, ProdutoServicoCadastro>): ProductsRemoteKeys? {
//
//        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let {
//
//                produto ->
//            produto.key?.let { remoteKeysDao.getRemoteKeys(id = it) }
//        }
//    }
//
//    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, ProdutoServicoCadastro>): ProductsRemoteKeys? {
//
//        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let {
//                produto ->
//            produto.key?.let { remoteKeysDao.getRemoteKeys(id = it) }
//        }
//    }
}
