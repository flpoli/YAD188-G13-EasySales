package com.poli.easysales.presentation.pedidos

import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro

sealed class OrderOverviewEvent {

    object OnNavigateToList : OrderOverviewEvent()
    data class OnClientSelected(val cliente: ClientesCadastro) : OrderOverviewEvent()
    data class OnProductSelected(val produtos: List<ProdutoServicoCadastro>) : OrderOverviewEvent()
}
