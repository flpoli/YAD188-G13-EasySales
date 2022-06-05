package com.poli.easysales.data.repository

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.produtos.ProdutoEntity
import com.poli.easysales.domain.repository.LocalDataSource
import com.poli.easysales.domain.repository.ProductsRepository
import com.poli.easysales.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl
@Inject constructor(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource
) : ProductsRepository {

    override fun getProductList(): Flow<PagingData<ProdutoEntity>> {

        return remote.getAllProducts()
    }

    override fun getProductsForSelection(): Flow<List<ProdutoEntity>> {
        return local.getProductsForSelection()
    }

    override suspend fun getSelectedProduct(productId: Long): ProdutoEntity {

        return local.getSelectedProduct(productId = productId)
    }
}
