package com.poli.prevendasomie.domain.usecase.products

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.domain.model.ListarProdutos
import kotlinx.coroutines.flow.Flow

interface GetProductsListUseCase {

    operator fun invoke(): Flow<Resource<ListarProdutos>>
}
