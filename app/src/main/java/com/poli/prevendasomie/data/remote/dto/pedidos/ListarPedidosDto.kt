package com.poli.prevendasomie.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.domain.model.pedidos.ListarPedidos

data class ListarPedidosDto(
    @SerializedName("pagina")
    val pagina: Int,
    @SerializedName("pedido_venda_produto")
    val pedidoVendaProduto: List<PedidoVendaProdutoDto>,
    @SerializedName("registros")
    val registros: Int?,
    @SerializedName("total_de_paginas")
    val totalDePaginas: Int?,
    @SerializedName("total_de_registros")
    val totalDeRegistros: Int?
)

fun ListarPedidosDto.toListarPedidos(): ListarPedidos {

    return ListarPedidos(
        pagina = pagina,
        registros = registros,
        totalDePaginas = totalDePaginas,
        totalDeRegistros = totalDeRegistros,
        pedidoVendaProduto = pedidoVendaProduto.map { it.toPedidoVendaProduto() } ?: emptyList()
    )
}
