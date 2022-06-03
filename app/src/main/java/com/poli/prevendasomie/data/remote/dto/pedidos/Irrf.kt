package com.poli.prevendasomie.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName

data class Irrf(
    @SerializedName("aliq_irrf")
    val aliqIrrf: Double?,
    @SerializedName("valor_irrf")
    val valorIrrf: Double?
)
