package com.poli.prevendasomie.data.remote.responses.clientes

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.domain.mappers.toClienteModel
import com.poli.prevendasomie.domain.model.clientes.ListarClientes

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

fun ListarClientesDto.toListarClientes(): ListarClientes {

    return ListarClientes(
        pagina = pagina,
        registros = registros,
        totalDePaginas = totalDePaginas,
        totalDeRegistros = totalDeRegistros,
        clientes = clientesCadastro.map { it.toClienteModel() }
    )
}
