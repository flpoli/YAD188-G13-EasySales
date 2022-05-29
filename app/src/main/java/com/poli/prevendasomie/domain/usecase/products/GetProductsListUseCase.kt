package com.poli.prevendasomie.domain.usecase.products

import androidx.paging.PagingData
import com.poli.prevendasomie.data.local.entities.produtos.ProdutoEntity
import kotlinx.coroutines.flow.Flow

interface GetProductsListUseCase {

    operator fun invoke(): Flow<PagingData<ProdutoEntity>>?
}
