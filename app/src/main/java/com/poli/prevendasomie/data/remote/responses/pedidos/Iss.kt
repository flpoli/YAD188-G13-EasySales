package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Iss(
    @SerializedName("aliq_iss")
    val aliqIss: Int?,
    @SerializedName("base_iss")
    val baseIss: Int?,
    @SerializedName("retem_iss")
    val retemIss: String?,
    @SerializedName("valor_iss")
    val valorIss: Int?
)
