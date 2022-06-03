package com.poli.prevendasomie.data.remote.dto.produtos

import com.google.gson.annotations.SerializedName

data class DadosIbpt(
    @SerializedName("aliqEstadual")
    val aliqEstadual: Int? = 0,
    @SerializedName("aliqFederal")
    val aliqFederal: Int? = 0,
    @SerializedName("aliqMunicipal")
    val aliqMunicipal: Int? = 0,
    @SerializedName("chave")
    val chave: String? = "",
    @SerializedName("fonte")
    val fonte: String? = "",
    @SerializedName("valido_ate")
    val validoAte: String? = "",
    @SerializedName("valido_de")
    val validoDe: String? = "",
    @SerializedName("versao")
    val versao: String? = ""
)
