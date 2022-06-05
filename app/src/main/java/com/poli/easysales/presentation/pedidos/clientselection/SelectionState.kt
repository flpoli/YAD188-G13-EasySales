package com.poli.easysales.presentation.pedidos.clientselection

data class SelectionState(

    val isLoading: Boolean = false,
    val selectableClient: List<SelectableClientUiState> = emptyList()

)
