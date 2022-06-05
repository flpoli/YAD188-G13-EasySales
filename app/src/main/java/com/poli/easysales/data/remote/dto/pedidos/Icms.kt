package com.poli.easysales.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName

data class Icms(
    @SerializedName("aliq_icms")
    val aliqIcms: Double?,
    @SerializedName("base_icms")
    val baseIcms: Double?,
    @SerializedName("cod_sit_trib_icms")
    val codSitTribIcms: String?,
    @SerializedName("modalidade_icms")
    val modalidadeIcms: String?,
    @SerializedName("origem_icms")
    val origemIcms: String?,
    @SerializedName("perc_red_base_icms")
    val percRedBaseIcms: Double?,
    @SerializedName("valor_icms")
    val valorIcms: Double?
)
