package com.poli.prevendasomie.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName

data class Iss(
    @SerializedName("aliq_iss")
    val aliqIss: Double?,
    @SerializedName("base_iss")
    val baseIss: Double?,
    @SerializedName("retem_iss")
    val retemIss: String?,
    @SerializedName("valor_iss")
    val valorIss: Double?
)
