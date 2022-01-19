package com.poli.prevendasomie.domain.model

import com.google.gson.annotations.SerializedName

data class ClientList (

    val clientes: List<ClientDetail>,
    val pagina: Int,
    val registros: Int,
    val totalDePaginas: Int,
    val totalDeRegistros: Int

    )
