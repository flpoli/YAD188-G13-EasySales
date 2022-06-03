package com.poli.prevendasomie.domain.usecase.products

import com.poli.prevendasomie.data.local.entities.produtos.ProdutoEntity

interface GetSelectedProduct {

    suspend operator fun invoke(productId: Long): ProdutoEntity
}
