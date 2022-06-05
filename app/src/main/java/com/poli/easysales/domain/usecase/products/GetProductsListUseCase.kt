package com.poli.easysales.domain.usecase.products

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.produtos.ProdutoEntity
import kotlinx.coroutines.flow.Flow

interface GetProductsListUseCase {

    operator fun invoke(): Flow<PagingData<ProdutoEntity>>?
}
