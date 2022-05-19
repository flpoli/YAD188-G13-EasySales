package com.poli.prevendasomie.presentation.pedidos.clientselection

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

sealed class SelectionEvent() {

    data class OnClientSelected(val cliente: ClientesCadastro) : SelectionEvent()
}
