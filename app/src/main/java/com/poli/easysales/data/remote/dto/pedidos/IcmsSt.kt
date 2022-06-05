package com.poli.easysales.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName

data class IcmsSt(
    @SerializedName("aliq_icms_opprop")
    val aliqIcmsOpprop: Double?,
    @SerializedName("aliq_icms_st")
    val aliqIcmsSt: Double?,
    @SerializedName("base_icms_st")
    val baseIcmsSt: Double?,
    @SerializedName("cest")
    val cest: String?,
    @SerializedName("cod_sit_trib_icms_st")
    val codSitTribIcmsSt: String?,
    @SerializedName("margem_icms_st")
    val margemIcmsSt: Double?,
    @SerializedName("modalidade_icms_st")
    val modalidadeIcmsSt: String?,
    @SerializedName("perc_red_base_icms_st")
    val percRedBaseIcmsSt: Double?,
    @SerializedName("valor_icms_st")
    val valorIcmsSt: Double?
)
