package com.poli.easysales.presentation.pedidos.clientselection

import com.poli.easysales.domain.model.clientes.ClientesCadastro

data class SelectableClientUiState(

    val cliente: ClientesCadastro,
    val isExpanded: Boolean = false,

)
