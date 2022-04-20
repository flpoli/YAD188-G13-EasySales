package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Ide(
    @SerializedName("codigo_item")
    val codigoItem: Int?,
    @SerializedName("codigo_item_integracao")
    val codigoItemIntegracao: String?,
    @SerializedName("id_ordem_producao")
    val idOrdemProducao: Int?,
    @SerializedName("simples_nacional")
    val simplesNacional: String?
)
