package com.poli.easysales.presentation.pedidos.productselection

import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro

sealed class ProductSelectionEvent {

    data class OnProductDeleted(
        val produto: ProdutoServicoCadastro?
    ) : ProductSelectionEvent()
    data class OnToggleSelectableProduct(
        val produto: ProdutoServicoCadastro?
    ) : ProductSelectionEvent()
    data class OnSelectProduct(
        val produto: ProdutoServicoCadastro?
    ) : ProductSelectionEvent()
    data class OnAmountForProductChange(
        val produto: ProdutoServicoCadastro?,
        val amount: String
    ) : ProductSelectionEvent()

    data class OnFinishSelection(val produtos: List<SelectableProductUiState>) : ProductSelectionEvent()
}
