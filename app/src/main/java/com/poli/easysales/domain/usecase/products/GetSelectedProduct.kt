package com.poli.easysales.domain.usecase.products

import com.poli.easysales.data.local.entities.produtos.ProdutoVendaEntity

interface GetSelectedProduct {

    suspend operator fun invoke(productId: Long): ProdutoVendaEntity
}
