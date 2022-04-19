package com.poli.prevendasomie.data.remote

import kotlin.String

sealed class Param {

    data class ParamConsultarCliente(
        val codigo_cliente_omie: String
    )

    data class ParamListarClientes(
        val apenas_importado_api: String = "N",
        val pagina: String,
        val registros_por_pagina: String
    )
    data class ParamListarProdutos(
        val apenas_importado_api: String = "N",
        val filtrar_apenas_omiepdv: String = "N",
        val pagina: String,
        val registros_por_pagina: String


    )
}
