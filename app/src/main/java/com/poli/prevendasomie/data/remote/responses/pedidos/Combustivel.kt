package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Combustivel(
    @SerializedName("nValorUFRem")
    val nValorUFRem: Int?
)
