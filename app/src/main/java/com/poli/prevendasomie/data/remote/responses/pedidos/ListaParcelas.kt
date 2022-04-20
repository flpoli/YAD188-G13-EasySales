package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class ListaParcelas(
    @SerializedName("parcela")
    val parcela: List<Parcela>?
)
