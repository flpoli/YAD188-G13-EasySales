package com.poli.easysales.presentation.pedidos.productselection

import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro

data class SelectableProductUiState(

    val produto: ProdutoServicoCadastro,
    val isSelected: Boolean = false,
    val isExpanded: Boolean = false,
    val amount: String = ""
)
