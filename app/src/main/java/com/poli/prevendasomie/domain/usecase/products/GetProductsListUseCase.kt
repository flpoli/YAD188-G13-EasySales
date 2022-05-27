package com.poli.prevendasomie.domain.usecase.products

import androidx.paging.PagingData
import com.poli.prevendasomie.data.local.entities.produtos.ProdutoEntity
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import kotlinx.coroutines.flow.Flow

interface GetProductsListUseCase {

    operator fun invoke(): Flow<PagingData<ProdutoEntity>>?
}
