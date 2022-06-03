package com.poli.prevendasomie.presentation.pedidos.clientselection

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

data class SelectableClientUiState(

    val cliente: ClientesCadastro,
    val isExpanded: Boolean = false,

)
