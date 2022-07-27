package com.poli.easysales.domain.usecase.pedidos

import com.poli.easysales.data.local.entities.produtos.ProdutoVendaEntity
import kotlinx.coroutines.flow.Flow

interface GetProductListForSelection {

    operator fun invoke(): Flow<List<ProdutoVendaEntity>>
}
