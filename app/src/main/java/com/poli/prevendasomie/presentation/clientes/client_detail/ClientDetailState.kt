package com.poli.prevendasomie.presentation.clientes.client_detail

import com.poli.prevendasomie.data.remote.responses.ClientesCadastroDto
import com.poli.prevendasomie.domain.model.ClientesCadastro

data class ClientDetailState(
    val isLoading: Boolean = false,
    val client: ClientesCadastro? = null,
    val error: String = ""
)
