package com.poli.prevendasomie.data.remote

import com.google.gson.annotations.SerializedName
import kotlin.String

sealed class Param {

    data class ParamConsultarCliente(
        @SerializedName("codigo_cliente_omie")
        val codigoClienteOmie: String
    )

    data class ParamListarClientes(
        @SerializedName("apenas_importado_api")
        val apenasImportadoApi: String = "N",
        val pagina: String,
        @SerializedName("registros_por_pagina")
        val registrosPorPagina: String
    )
    data class ParamListarProdutos(
        @SerializedName("apenas_importado_api")
        val apenasImportadoApi: String = "N",
        @SerializedName("filtrar_apenas_omiepdv")
        val filtrarApenasOmiepdv: String = "N",
        val pagina: String,
        @SerializedName("registros_por_pagina")
        val registrosPorPagina: String

    )
}
