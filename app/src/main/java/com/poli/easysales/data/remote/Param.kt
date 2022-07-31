package com.poli.easysales.data.remote

import com.google.gson.annotations.SerializedName
import java.util.*
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
    data class ParamListarPedidos(
        val pagina: String,
        @SerializedName("apenas_importado_api")
        val apenasImportadoApi: String = "N",
        @SerializedName("registros_por_pagina")
        val registrosPorPagina: String
    )

    data class ParamListarPosicao(
        val nPagina: Int = 0,
        val nRegPorPagina: Int = 0,
        val dDataPosicao: Date
    )

    data class ParamCaracCliente(

        @SerializedName("codigo_cliente_omie")
        val codigoCliente: Long
    )
    data class ParamListarCategorias(
        val pagina: Int = 1,
        @SerializedName("registros_por_pagina")
        val registrosPorPagina: Int = 500,
        @SerializedName("filtrar_apenas_ativo")
        val filtrarApenasAtivo: String = "S",
        @SerializedName("filtrar_por_tipo")
        val filtrarPorTipo: String = "R"
    )
}
