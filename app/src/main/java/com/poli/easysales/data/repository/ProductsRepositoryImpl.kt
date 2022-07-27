package com.poli.easysales.data.repository

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.produtos.ProdutoVendaEntity
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

    override fun getProductList(): Flow<PagingData<ProdutoVendaEntity>> {

        return remote.getAllProducts()
    }

    override fun getProductsForSelection(): Flow<List<ProdutoVendaEntity>> {
        return local.getProductsForSelection()
    }

    override suspend fun getSelectedProduct(productId: Long): ProdutoVendaEntity {

        return local.getSelectedProduct(productId = productId)
    }
}
