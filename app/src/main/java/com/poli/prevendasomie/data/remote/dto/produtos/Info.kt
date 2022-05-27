package com.poli.prevendasomie.data.remote.dto.produtos

import com.google.gson.annotations.SerializedName

data class Info(
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
