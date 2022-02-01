package com.poli.prevendasomie.data.remote.responses


import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.domain.model.ClientDetail
import com.poli.prevendasomie.domain.model.ClientList

data class ListarClientes(
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

//fun ListarClientes.toClientList(): ClientList{
//
//    return ClientList(
//        pagina = pagina,
//        registros = registros,
//        totalDePaginas = totalDePaginas,
//        totalDeRegistros = totalDeRegistros
//        //clientesCadastro = List<ClientDetail>
//    )
//}