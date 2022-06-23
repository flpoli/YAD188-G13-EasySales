package com.poli.easysales.data.remote.dto.clientes

import com.google.gson.annotations.SerializedName

data class ListarClientesDto(
    @SerializedName("clientes_cadastro")
    val clientesCadastro: List<ClientesCadastroDto>,
    @SerializedName("pagina")
    val pagina: Int,
    @SerializedName("registros")
    val registros: Int,
    @SerializedName("total_de_paginas")
    val totalDePaginas: Int,
    @SerializedName("total_de_registros")
    val totalDeRegistros: Int
)
