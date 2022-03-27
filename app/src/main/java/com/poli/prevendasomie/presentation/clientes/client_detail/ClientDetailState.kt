package com.poli.prevendasomie.presentation.clientes.client_detail

import com.poli.prevendasomie.data.remote.responses.ClientesCadastroDto

data class ClientDetailState(
    val isLoading: Boolean = false,
    val client: ClientesCadastroDto? = null,
    val error: String = ""
)


