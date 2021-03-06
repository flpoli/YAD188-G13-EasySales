package com.poli.prevendasomie.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class InfoCadastro(
    @SerializedName("autorizado")
    val autorizado: String? = "",
    @SerializedName("cImpAPI")
    val cImpAPI: String? = "",
    @SerializedName("cancelado")
    val cancelado: String? = "",
    @SerializedName("dAlt")
    val dAlt: String? = "",
    @SerializedName("dCan")
    val dCan: String? = "",
    @SerializedName("dFat")
    val dFat: String? = "",
    @SerializedName("dInc")
    val dInc: String? = "",
    @SerializedName("denegado")
    val denegado: String? = "",
    @SerializedName("devolvido")
    val devolvido: String? = "",
    @SerializedName("devolvido_parcial")
    val devolvidoParcial: String? = "",
    @SerializedName("faturado")
    val faturado: String? = "",
    @SerializedName("hAlt")
    val hAlt: String? = "",
    @SerializedName("hCan")
    val hCan: String? = "",
    @SerializedName("hFat")
    val hFat: String? = "",
    @SerializedName("hInc")
    val hInc: String? = "",
    @SerializedName("uAlt")
    val uAlt: String? = "",
    @SerializedName("uCan")
    val uCan: String? = "",
    @SerializedName("uFat")
    val uFat: String? = "",
    @SerializedName("uInc")
    val uInc: String? = ""
)
