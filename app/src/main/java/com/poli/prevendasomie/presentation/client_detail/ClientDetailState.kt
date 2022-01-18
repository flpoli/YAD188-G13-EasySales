package com.poli.prevendasomie.presentation.client_detail

import com.poli.prevendasomie.data.remote.responses.ClientesCadastro

data class ClientDetailState(
    val isLoading: Boolean = false,
    val client: ClientesCadastro? = null,
    val error: String = ""
)
