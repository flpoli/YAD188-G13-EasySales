package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Observacao(
    @SerializedName("obs_item")
    val obsItem: String?
)
