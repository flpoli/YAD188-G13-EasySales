package com.poli.easysales.presentation.clientes.client_detail

import com.poli.easysales.domain.model.clientes.ClientesCadastro

data class ClientDetailState(
    val isLoading: Boolean = false,
    val client: ClientesCadastro? = null,
    val error: String = ""
)
