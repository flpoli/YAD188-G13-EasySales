package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Observacoes(
    @SerializedName("obs_venda")
    val obsVenda: String?
)
