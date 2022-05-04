package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class IcmsIe(
    @SerializedName("aliq_icms_FCP")
    val aliqIcmsFCP: Double?,
    @SerializedName("aliq_interestadual")
    val aliqInterestadual: Double?,
    @SerializedName("aliq_interna_uf_destino")
    val aliqInternaUfDestino: Double?,
    @SerializedName("aliq_partilha_icms")
    val aliqPartilhaIcms: Double?,
    @SerializedName("base_icms_uf_destino")
    val baseIcmsUfDestino: Double?,
    @SerializedName("valor_fcp_icms_inter")
    val valorFcpIcmsInter: Double?,
    @SerializedName("valor_icms_uf_dest")
    val valorIcmsUfDest: Double?,
    @SerializedName("valor_icms_uf_remet")
    val valorIcmsUfRemet: Double?
)
