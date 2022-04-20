package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class IcmsSt(
    @SerializedName("aliq_icms_opprop")
    val aliqIcmsOpprop: Int?,
    @SerializedName("aliq_icms_st")
    val aliqIcmsSt: Int?,
    @SerializedName("base_icms_st")
    val baseIcmsSt: Int?,
    @SerializedName("cest")
    val cest: String?,
    @SerializedName("cod_sit_trib_icms_st")
    val codSitTribIcmsSt: String?,
    @SerializedName("margem_icms_st")
    val margemIcmsSt: Int?,
    @SerializedName("modalidade_icms_st")
    val modalidadeIcmsSt: String?,
    @SerializedName("perc_red_base_icms_st")
    val percRedBaseIcmsSt: Int?,
    @SerializedName("valor_icms_st")
    val valorIcmsSt: Int?
)
