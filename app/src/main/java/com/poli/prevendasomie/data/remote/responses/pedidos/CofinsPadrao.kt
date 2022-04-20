package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class CofinsPadrao(
    @SerializedName("aliq_cofins")
    val aliqCofins: Int?,
    @SerializedName("base_cofins")
    val baseCofins: Int?,
    @SerializedName("cod_sit_trib_cofins")
    val codSitTribCofins: String?,
    @SerializedName("qtde_unid_trib_cofins")
    val qtdeUnidTribCofins: Int?,
    @SerializedName("tipo_calculo_cofins")
    val tipoCalculoCofins: String?,
    @SerializedName("valor_cofins")
    val valorCofins: Int?,
    @SerializedName("valor_unid_trib_cofins")
    val valorUnidTribCofins: Int?
)
