package com.poli.easysales.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName

data class Exportacao(
    @SerializedName("nao_exportacao")
    val naoExportacao: String?
)
