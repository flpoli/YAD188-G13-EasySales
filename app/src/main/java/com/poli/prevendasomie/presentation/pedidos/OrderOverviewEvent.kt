package com.poli.prevendasomie.presentation.pedidos

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

sealed class OrderOverviewEvent {


    data class OnClientSelected(val cliente: ClientesCadastro): OrderOverviewEvent()
}
