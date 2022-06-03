package com.poli.prevendasomie.domain.usecase.pedidos

import com.poli.prevendasomie.data.local.entities.produtos.ProdutoEntity
import kotlinx.coroutines.flow.Flow

interface GetProductListForSelection {

    operator fun invoke(): Flow<List<ProdutoEntity>>
}
