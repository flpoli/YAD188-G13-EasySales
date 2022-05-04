package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Ide(
    @SerializedName("codigo_item")
    val codigoItem: Long?,
    @SerializedName("codigo_item_integracao")
    val codigoItemIntegracao: String?,
    @SerializedName("id_ordem_producao")
    val idOrdemProducao: Long?,
    @SerializedName("simples_nacional")
    val simplesNacional: String?
)
