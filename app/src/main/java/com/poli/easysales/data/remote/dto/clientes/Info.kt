package com.poli.easysales.data.remote.dto.clientes

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("cImpAPI")
    val cImpAPI: String? = "",
    @SerializedName("dAlt")
    val dAlt: String? = "",
    @SerializedName("dInc")
    val dInc: String? = "",
    @SerializedName("hAlt")
    val hAlt: String? = "",
    @SerializedName("hInc")
    val hInc: String? = "",
    @SerializedName("uAlt")
    val uAlt: String? = "",
    @SerializedName("uInc")
    val uInc: String? = ""
)
