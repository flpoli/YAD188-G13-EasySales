package com.poli.prevendasomie.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName

data class PisSt(
    @SerializedName("aliq_pis_st")
    val aliqPisSt: Double?,
    @SerializedName("base_pis_st")
    val basePisSt: Double?,
    @SerializedName("cod_sit_trib_pis_st")
    val codSitTribPisSt: String?,
    @SerializedName("margem_pis_st")
    val margemPisSt: Double?,
    @SerializedName("qtde_unid_trib_pis_st")
    val qtdeUnidTribPisSt: Int?,
    @SerializedName("tipo_calculo_pis_st")
    val tipoCalculoPisSt: String?,
    @SerializedName("valor_pis_st")
    val valorPisSt: Double?,
    @SerializedName("valor_unid_trib_pis_st")
    val valorUnidTribPisSt: Double?
)
