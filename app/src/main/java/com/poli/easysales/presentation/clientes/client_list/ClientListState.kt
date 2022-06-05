package com.poli.easysales.presentation.clientes.client_list

import com.poli.easysales.domain.model.clientes.ListarClientes

data class ClientListState(

    val isLoading: Boolean = false,
    val clientes: ListarClientes? = null,
    val error: String? = null

)
