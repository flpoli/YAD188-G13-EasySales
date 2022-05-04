package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class PisPadrao(
    @SerializedName("aliq_pis")
    val aliqPis: Double?,
    @SerializedName("base_pis")
    val basePis: Double?,
    @SerializedName("cod_sit_trib_pis")
    val codSitTribPis: String?,
    @SerializedName("qtde_unid_trib_pis")
    val qtdeUnidTribPis: Int?,
    @SerializedName("tipo_calculo_pis")
    val tipoCalculoPis: String?,
    @SerializedName("valor_pis")
    val valorPis: Double?,
    @SerializedName("valor_unid_trib_pis")
    val valorUnidTribPis: Double?
)
