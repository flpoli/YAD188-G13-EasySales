package com.poli.prevendasomie.presentation.pedidos.searchclient

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

data class SearchState(

    val query: String = "",
    val isSearching: Boolean = false,
    val selectableClient: List<ClientesCadastro> = emptyList()
)
