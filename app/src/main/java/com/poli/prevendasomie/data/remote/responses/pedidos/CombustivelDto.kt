package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class CombustivelDto(
    @SerializedName("nValorUFRem")
    val nValorUFRem: Int?
)
