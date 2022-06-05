package com.poli.easysales.domain.model.pedidos

data class ListarPedidos(
    val pagina: Int?,
    val registros: Int?,
    val totalDePaginas: Int?,
    val totalDeRegistros: Int?,
    val pedidoVendaProduto: List<PedidoVendaProduto>
)
