package com.poli.prevendasomie.presentation.pedidos.clientselection

data class SelectionState(

    val isLoading: Boolean = false,
    val selectableClient: List<SelectableClientUiState> = emptyList()

)
