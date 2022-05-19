package com.poli.prevendasomie.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class Observacoes(
    @SerializedName("obs_venda")
    val obsVenda: String? = ""
)
