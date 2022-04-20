package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Csll(
    @SerializedName("aliq_csll")
    val aliqCsll: Int?,
    @SerializedName("valor_csll")
    val valorCsll: Int?
)
