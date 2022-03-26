package com.poli.prevendasomie.data.models


import com.google.gson.annotations.SerializedName

data class Param(
    @SerializedName("apenas_importado_api")
    val apenasImportadoApi: String,
    @SerializedName("pagina")
    val pagina: Int,
    @SerializedName("registros_por_pagina")
    val registrosPorPagina: Int
)