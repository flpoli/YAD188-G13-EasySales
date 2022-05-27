package com.poli.prevendasomie.presentation.pedidos.clientselection

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

sealed class ClientSelectionEvent() {

    data class OnClientSelected(val cliente: ClientesCadastro) : ClientSelectionEvent()
}
