package com.poli.prevendasomie.presentation.pedidos.productselection

import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro

data class SelectableProductUiState(

    val produto: ProdutoServicoCadastro,
    val isExpanded: Boolean = false
)
