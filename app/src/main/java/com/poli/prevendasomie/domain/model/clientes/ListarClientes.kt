package com.poli.prevendasomie.domain.model.clientes

import com.poli.prevendasomie.domain.model.ClientesCadastro

data class ListarClientes(

    val clientes: List<ClientesCadastro>,
    val pagina: Int,
    val registros: Int,
    val totalDePaginas: Int,
    val totalDeRegistros: Int

)
