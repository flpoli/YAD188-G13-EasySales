package com.poli.prevendasomie.presentation.produtos.productslist

import com.poli.prevendasomie.domain.model.produtos.ListarProdutos

data class ProductsListState(
    val isLoading: Boolean = false,
    val produtos: ListarProdutos? = null,
    val error: String? = null
)
