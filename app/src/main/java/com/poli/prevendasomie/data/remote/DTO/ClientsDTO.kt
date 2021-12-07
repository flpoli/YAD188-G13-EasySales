package com.poli.prevendasomie.data.remote.DTO

data class ClientsDTO(
    val clientes_cadastro: List<ClientesCadastro>,
    val pagina: Int,
    val registros: Int,
    val total_de_paginas: Int,
    val total_de_registros: Int
)