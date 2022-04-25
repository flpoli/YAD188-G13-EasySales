
package com.poli.prevendasomie.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.poli.prevendasomie.data.local.ErpDatabase
import com.poli.prevendasomie.data.pagingsource.ProductsRemoteMediator
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val api: OmieAPI,
    private val db: ErpDatabase
) : RemoteDataSource {

    private val productDao = db.productsDao()

    override fun getAllProducts(): Flow<PagingData<ProdutoServicoCadastro>> {

        val pagingSourceFactory = { productDao.getAllProducts() }

        return Pager(
            config = PagingConfig(pageSize = 30, enablePlaceholders = false),
            remoteMediator = ProductsRemoteMediator(
                api,
                db
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}
