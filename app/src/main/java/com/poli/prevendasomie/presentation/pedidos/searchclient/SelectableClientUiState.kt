package com.poli.prevendasomie.presentation.pedidos.searchclient

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

data class SelectableClientUiState(

    val cliente: ClientesCadastro? = null ,
    val isExpanded: Boolean = false

)
