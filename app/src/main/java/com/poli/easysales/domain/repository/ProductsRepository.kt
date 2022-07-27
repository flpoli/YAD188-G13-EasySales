package com.poli.easysales.domain.repository

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.produtos.ProdutoVendaEntity
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getProductList(): Flow<PagingData<ProdutoVendaEntity>>?
    fun getProductsForSelection(): Flow<List<ProdutoVendaEntity>>
    suspend fun getSelectedProduct(productId: Long): ProdutoVendaEntity
}
