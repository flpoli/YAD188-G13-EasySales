package com.poli.prevendasomie.domain.model

data class ListarClientes (

    val clientes: List<ClientesCadastro>,
    val pagina: Int,
    val registros: Int,
    val totalDePaginas: Int,
    val totalDeRegistros: Int

    )
