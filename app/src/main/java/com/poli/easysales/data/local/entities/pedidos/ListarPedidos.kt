package com.poli.easysales.data.local.entities.pedidos

import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

data class ListarPedidos(
    val pagina: Int?,
    val registros: Int?,
    val totalDePaginas: Int?,
    val totalDeRegistros: Int?,
    val pedidoVendaProduto: List<PedidoVendaProduto>
)
