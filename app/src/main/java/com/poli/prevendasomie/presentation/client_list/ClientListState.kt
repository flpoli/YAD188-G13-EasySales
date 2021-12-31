package com.poli.prevendasomie.presentation.client_list

import com.poli.prevendasomie.domain.model.Client

data class ClientListState(

    val isLoading: Boolean = false,
    val clients: List<Client> = emptyList(),
    val error: String = ""

)
