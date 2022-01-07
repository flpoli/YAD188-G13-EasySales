package com.poli.prevendasomie.data.remote.responses


import com.google.gson.annotations.SerializedName

data class ClientList(
    @SerializedName("clientes_cadastro")
    val clientesCadastro: List<ClientesCadastro>,
    @SerializedName("pagina")
    val pagina: Int,
    @SerializedName("registros")
    val registros: Int,
    @SerializedName("total_de_paginas")
    val totalDePaginas: Int,
    @SerializedName("total_de_registros")
    val totalDeRegistros: Int
)