package com.poli.prevendasomie.domain.model

data class ClientList (

    val clientes: List<ClientDetail>,
    val pagina: Int,
    val registros: Int,
    val totalDePaginas: Int,
    val totalDeRegistros: Int

    )
