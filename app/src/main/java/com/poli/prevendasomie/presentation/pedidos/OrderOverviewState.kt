package com.poli.prevendasomie.presentation.pedidos

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro

data class OrderOverviewState(

    val cliente: ClientesCadastro = ClientesCadastro(),
    val produtos: List<ProdutoServicoCadastro> = emptyList()

)
