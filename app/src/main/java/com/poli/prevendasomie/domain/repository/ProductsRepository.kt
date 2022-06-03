package com.poli.prevendasomie.domain.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.data.local.entities.produtos.ProdutoEntity
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getProductList(): Flow<PagingData<ProdutoEntity>>?
    fun getProductsForSelection(): Flow<List<ProdutoEntity>>
    suspend fun getSelectedProduct(productId: Long): ProdutoEntity
}
