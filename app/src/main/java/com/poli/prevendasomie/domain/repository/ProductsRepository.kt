package com.poli.prevendasomie.domain.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getProductList(): Flow<PagingData<ProdutoServicoCadastro>>?
    suspend fun getSelectedProduct(productId: Long): ProdutoServicoCadastro
}
