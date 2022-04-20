package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class IcmsIe(
    @SerializedName("aliq_icms_FCP")
    val aliqIcmsFCP: Int?,
    @SerializedName("aliq_interestadual")
    val aliqInterestadual: Int?,
    @SerializedName("aliq_interna_uf_destino")
    val aliqInternaUfDestino: Int?,
    @SerializedName("aliq_partilha_icms")
    val aliqPartilhaIcms: Int?,
    @SerializedName("base_icms_uf_destino")
    val baseIcmsUfDestino: Double?,
    @SerializedName("valor_fcp_icms_inter")
    val valorFcpIcmsInter: Int?,
    @SerializedName("valor_icms_uf_dest")
    val valorIcmsUfDest: Int?,
    @SerializedName("valor_icms_uf_remet")
    val valorIcmsUfRemet: Int?
)
