package com.poli.easysales.data.remote.dto.categorias


import com.google.gson.annotations.SerializedName

data class DadosDRE(
    @SerializedName("codigoDRE")
    val codigoDRE: String?,
    @SerializedName("descricaoDRE")
    val descricaoDRE: String?,
    @SerializedName("naoExibirDRE")
    val naoExibirDRE: String?,
    @SerializedName("nivelDRE")
    val nivelDRE: Int?,
    @SerializedName("sinalDRE")
    val sinalDRE: String?,
    @SerializedName("totalizaDRE")
    val totalizaDRE: String?
)