package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class CofinsSt(
    @SerializedName("aliq_cofins_st")
    val aliqCofinsSt: Double?,
    @SerializedName("base_cofins_st")
    val baseCofinsSt: Double?,
    @SerializedName("cod_sit_trib_cofins_st")
    val codSitTribCofinsSt: String?,
    @SerializedName("margem_cofins_st")
    val margemCofinsSt: Double?,
    @SerializedName("qtde_unid_trib_cofins_st")
    val qtdeUnidTribCofinsSt: Int?,
    @SerializedName("tipo_calculo_cofins_st")
    val tipoCalculoCofinsSt: String?,
    @SerializedName("valor_cofins_st")
    val valorCofinsSt: Double?,
    @SerializedName("valor_unid_trib_cofins_st")
    val valorUnidTribCofinsSt: Double?
)
