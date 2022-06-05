package com.poli.easysales.presentation.produtos.productslist

import com.poli.easysales.domain.model.produtos.ListarProdutos

data class ProductsListState(
    val isLoading: Boolean = false,
    val produtos: ListarProdutos? = null,
    val error: String? = null
)
