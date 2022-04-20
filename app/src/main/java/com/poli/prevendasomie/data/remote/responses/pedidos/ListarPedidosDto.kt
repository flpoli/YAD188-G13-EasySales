package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class ListarPedidosDto(
    @SerializedName("pagina")
    val pagina: Int?,
    @SerializedName("pedido_venda_produto")
    val pedidoVendaProduto: List<PedidoVendaProduto>?,
    @SerializedName("registros")
    val registros: Int?,
    @SerializedName("total_de_paginas")
    val totalDePaginas: Int?,
    @SerializedName("total_de_registros")
    val totalDeRegistros: Int?
)
