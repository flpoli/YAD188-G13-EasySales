package com.poli.prevendasomie.domain.usecase.products

import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro

interface GetSelectedProduct {

    suspend operator fun invoke(productId: Long): ProdutoServicoCadastro
}
