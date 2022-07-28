package com.poli.easysales.presentation.pedidos

import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.presentation.pedidos.productselection.SelectableProductUiState

sealed class OrderOverviewEvent {

    object OnNavigateToList : OrderOverviewEvent()

    object OnSubmitOrder : OrderOverviewEvent()
    data class OnClientSelected(val cliente: ClientesCadastro) : OrderOverviewEvent()
    data class OnProductSelected(val produtos: List<SelectableProductUiState>) : OrderOverviewEvent()
}
