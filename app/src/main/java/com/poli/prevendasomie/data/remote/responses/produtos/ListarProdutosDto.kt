package com.poli.prevendasomie.data.remote.responses.produtos


import com.google.gson.annotations.SerializedName

data class ListarProdutosDto(
    @SerializedName("pagina")
    val pagina: Int?,
    @SerializedName("produto_servico_cadastro")
    val produtoServicoCadastro: List<ProdutoServicoCadastroDto>?,
    @SerializedName("registros")
    val registros: Int?,
    @SerializedName("total_de_paginas")
    val totalDePaginas: Int?,
    @SerializedName("total_de_registros")
    val totalDeRegistros: Int?
)