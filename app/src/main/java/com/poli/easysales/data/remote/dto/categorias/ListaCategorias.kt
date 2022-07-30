package com.poli.easysales.data.remote.dto.categorias


import com.google.gson.annotations.SerializedName

data class ListaCategorias(
    @SerializedName("categoria_cadastro")
    val categoriaCadastro: List<CategoriaCadastro?>?,
    @SerializedName("pagina")
    val pagina: Int?,
    @SerializedName("registros")
    val registros: Int?,
    @SerializedName("total_de_paginas")
    val totalDePaginas: Int?,
    @SerializedName("total_de_registros")
    val totalDeRegistros: Int?
)