package com.poli.prevendasomie.presentation.pedidos

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro

sealed class OrderOverviewEvent {

    object OnNavigateToList : OrderOverviewEvent()
    data class OnClientSelected(val cliente: ClientesCadastro) : OrderOverviewEvent()
    data class OnProductSelected(val produtos: List<ProdutoServicoCadastro>): OrderOverviewEvent()
}
