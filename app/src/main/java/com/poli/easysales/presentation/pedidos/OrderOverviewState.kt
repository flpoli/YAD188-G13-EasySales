package com.poli.easysales.presentation.pedidos

import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro

data class OrderOverviewState(

    val cliente: ClientesCadastro = ClientesCadastro(),
    val produtos: List<ProdutoServicoCadastro> = emptyList()

)
