package com.poli.prevendasomie.presentation.pedidos.searchclient

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

sealed class SearchEvent {


    data class OnQueryChange(val query: String): SearchEvent()
    object OnSearch: SearchEvent()
    data class OnToggleSelectableClient(val cliente: ClientesCadastro): SearchEvent()
    data class OnSelectClient(val cliente: ClientesCadastro): SearchEvent()



}
