package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class IcmsSn(
    @SerializedName("aliq_icms_sn")
    val aliqIcmsSn: Int?,
    @SerializedName("base_icms_sn")
    val baseIcmsSn: Int?,
    @SerializedName("cod_sit_trib_icms_sn")
    val codSitTribIcmsSn: String?,
    @SerializedName("origem_icms_sn")
    val origemIcmsSn: String?,
    @SerializedName("valor_credito_icms_sn")
    val valorCreditoIcmsSn: Int?,
    @SerializedName("valor_icms_sn")
    val valorIcmsSn: Int?
)
