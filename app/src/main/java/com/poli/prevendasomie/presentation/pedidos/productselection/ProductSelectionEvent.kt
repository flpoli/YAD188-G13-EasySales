package com.poli.prevendasomie.presentation.pedidos.productselection

import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro

sealed class ProductSelectionEvent() {

    data class OnProductDeleted(val produto: ProdutoServicoCadastro): ProductSelectionEvent()
    data class OnToggleSelectableProduct(val produto: ProdutoServicoCadastro): ProductSelectionEvent()
    data class OnAmountForProductChange(val produto: ProdutoServicoCadastro, val amount: String): ProductSelectionEvent()

}
