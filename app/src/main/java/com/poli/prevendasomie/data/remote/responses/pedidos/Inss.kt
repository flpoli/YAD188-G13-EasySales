package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Inss(
    @SerializedName("aliq_inss")
    val aliqInss: Int?,
    @SerializedName("valor_inss")
    val valorInss: Int?
)
