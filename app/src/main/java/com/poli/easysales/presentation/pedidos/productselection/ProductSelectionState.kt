package com.poli.easysales.presentation.pedidos.productselection

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class ProductSelectionState(

    val isLoading: Boolean = false,
    val selectableProduct: List<SelectableProductUiState> = emptyList()
)
