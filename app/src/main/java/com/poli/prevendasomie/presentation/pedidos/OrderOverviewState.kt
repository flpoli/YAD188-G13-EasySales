package com.poli.prevendasomie.presentation.pedidos

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro

data class OrderOverviewState(

    var cliente: ClientesCadastro = ClientesCadastro(),
    var produtos: List<ProdutoServicoCadastro> = emptyList()

)
