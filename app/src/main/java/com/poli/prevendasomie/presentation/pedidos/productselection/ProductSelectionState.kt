package com.poli.prevendasomie.presentation.pedidos.productselection

data class ProductSelectionState(

    val isLoading: Boolean = false,
    val selectableProduct: List<SelectableProductUiState> = emptyList()
)
