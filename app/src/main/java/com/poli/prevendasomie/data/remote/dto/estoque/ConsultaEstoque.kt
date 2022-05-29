package com.poli.prevendasomie.data.remote.dto.estoque

import com.google.gson.annotations.SerializedName

data class ConsultaEstoque(
    @SerializedName("dDataPosicao")
    val dDataPosicao: String?,
    @SerializedName("nPagina")
    val nPagina: Int?,
    @SerializedName("nRegistros")
    val nRegistros: Int?,
    @SerializedName("nTotPaginas")
    val nTotPaginas: Int?,
    @SerializedName("nTotRegistros")
    val nTotRegistros: Int?,
    @SerializedName("produtos")
    val produtos: List<Produto>?
)
