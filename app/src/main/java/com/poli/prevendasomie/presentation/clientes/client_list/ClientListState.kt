package com.poli.prevendasomie.presentation.clientes.client_list

import com.poli.prevendasomie.domain.model.clientes.ListarClientes

data class ClientListState(

    val isLoading: Boolean = false,
    val clientes: ListarClientes? = null,
    val error: String? = null

)
