package com.poli.prevendasomie.presentation.clientes.client_detail

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

data class ClientDetailState(
    val isLoading: Boolean = false,
    val client: ClientesCadastro? = null,
    val error: String = ""
)
