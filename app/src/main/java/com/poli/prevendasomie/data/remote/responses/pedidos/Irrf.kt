package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Irrf(
    @SerializedName("aliq_irrf")
    val aliqIrrf: Int?,
    @SerializedName("valor_irrf")
    val valorIrrf: Int?
)
