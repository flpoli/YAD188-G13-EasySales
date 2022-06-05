package com.poli.easysales.presentation.pedidos.clientselection

import com.poli.easysales.domain.model.clientes.ClientesCadastro

sealed class ClientSelectionEvent {

    data class OnClientSelected(val cliente: ClientesCadastro) : ClientSelectionEvent()
}
