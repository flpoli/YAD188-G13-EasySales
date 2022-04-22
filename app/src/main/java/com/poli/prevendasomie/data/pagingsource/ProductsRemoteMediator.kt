package com.poli.prevendasomie.data.pagingsource

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.domain.model.produtos.ProductsRemoteKeys
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import javax.inject.Inject

@ExperimentalPagingApi
class ProductsRemoteMediator
    @Inject constructor(
        api: OmieAPI,
        db: ErpDatabase
): RemoteMediator<Int, ProdutoServicoCadastro>() {

    private val productDao = db.productsDao()
    private val remoteKeysDao = db.productRemoteKeysDao()

    override suspend fun initialize(): InitializeAction {

        val currentTime = System.currentTimeMillis()
        val lastUpdated = remoteKeysDao.getRemoteKeys(id = 1)?.lastUpdated ?: 0L
        val cacheTimeout = 1440
        val diffInMinutes = (currentTime - lastUpdated) / 1000 / 60

        return if(diffInMinutes.toInt() <= cacheTimeout) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else{
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ProdutoServicoCadastro>
    ): MediatorResult {

        TODO()

    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, ProdutoServicoCadastro>): ProductsRemoteKeys? {

        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.codigoProduto?.let { id ->

                remoteKeysDao.getRemoteKeys(id = id.toInt())
            }
        }

    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, ProdutoServicoCadastro>): ProductsRemoteKeys? {

        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let {

                produto ->
                    remoteKeysDao.getRemoteKeys(id = produto.codigoProduto.toInt())
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, ProdutoServicoCadastro>): ProductsRemoteKeys? {

        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let {
                produto -> remoteKeysDao.getRemoteKeys(id = produto.codigoProduto.toInt())
        }
    }

}