package com.poli.easysales.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName

data class Ide(
    @SerializedName("codigo_item")
    val codigoItem: Long? = 0,
    @SerializedName("codigo_item_integracao")
    val codigoItemIntegracao: String? = "",
    @SerializedName("id_ordem_producao")
    val idOrdemProducao: Long? = 0,
    @SerializedName("simples_nacional")
    val simplesNacional: String? = ""
)
