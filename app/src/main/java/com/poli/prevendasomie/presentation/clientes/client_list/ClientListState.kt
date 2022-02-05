package com.poli.prevendasomie.presentation.clientes.client_list

import com.poli.prevendasomie.domain.model.ClientList

data class ClientListState(

    val isLoading: Boolean = false,
    val clientes: List<ClientList> = emptyList(),
    val error: String = ""

)
