package com.poli.prevendasomie.domain.usecase.pedidos

import com.poli.prevendasomie.data.local.entities.produtos.ProdutoEntity
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import kotlinx.coroutines.flow.Flow

interface GetProductListForSelection {

    operator fun invoke(): Flow<List<ProdutoEntity>>
}