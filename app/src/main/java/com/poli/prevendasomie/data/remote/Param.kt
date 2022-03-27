package com.poli.prevendasomie.data.remote

sealed class Param {

    data class ParamConsultarCliente(
        val codigo_cliente_omie: String
    )

    data class ParamListarClientes(
        val apenas_importado_api: String,
        val pagina: String,
        val registros_por_pagina: String
    )
}
