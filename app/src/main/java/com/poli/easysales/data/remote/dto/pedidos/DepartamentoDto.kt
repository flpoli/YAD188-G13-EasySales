package com.poli.easysales.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName

data class DepartamentoDto(
    @SerializedName("cCodDepto")
    val cCodDepto: String?,
    @SerializedName("nPerc")
    val nPerc: Double?,
    @SerializedName("nValor")
    val nValor: Double?,
    @SerializedName("nValorFixo")
    val nValorFixo: String?
)
