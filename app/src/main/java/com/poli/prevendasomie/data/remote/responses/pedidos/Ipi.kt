package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Ipi(
    @SerializedName("aliq_ipi")
    val aliqIpi: Double?,
    @SerializedName("base_ipi")
    val baseIpi: Double?,
    @SerializedName("cod_sit_trib_ipi")
    val codSitTribIpi: String?,
    @SerializedName("enquadramento_ipi")
    val enquadramentoIpi: String?,
    @SerializedName("qtde_unid_trib_ipi")
    val qtdeUnidTribIpi: Int?,
    @SerializedName("tipo_calculo_ipi")
    val tipoCalculoIpi: String?,
    @SerializedName("valor_ipi")
    val valorIpi: Double?,
    @SerializedName("valor_unid_trib_ipi")
    val valorUnidTribIpi: Double?
)
