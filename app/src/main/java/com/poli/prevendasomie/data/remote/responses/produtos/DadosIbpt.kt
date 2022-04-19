package com.poli.prevendasomie.data.remote.responses.produtos

import com.google.gson.annotations.SerializedName

data class DadosIbpt(
    @SerializedName("aliqEstadual")
    val aliqEstadual: Int?,
    @SerializedName("aliqFederal")
    val aliqFederal: Int?,
    @SerializedName("aliqMunicipal")
    val aliqMunicipal: Int?,
    @SerializedName("chave")
    val chave: String?,
    @SerializedName("fonte")
    val fonte: String?,
    @SerializedName("valido_ate")
    val validoAte: String?,
    @SerializedName("valido_de")
    val validoDe: String?,
    @SerializedName("versao")
    val versao: String?
)
