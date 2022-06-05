package com.poli.easysales.domain.usecase.products

import com.poli.easysales.data.local.entities.produtos.ProdutoEntity

interface GetSelectedProduct {

    suspend operator fun invoke(productId: Long): ProdutoEntity
}
