package com.poli.easysales.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ReqResponse(

    @SerializedName("faultstring")
    val faultString: String? = null,
    @SerializedName("faultcode")
    val faultCode: String? = null,
    @SerializedName("codigo_status")
    val codigoStatus: String? = null,
    @SerializedName("descricao_status")
    val descricaoStatus: String? = null,
    @SerializedName("codigo_cliente_integracao")
    val codigoClienteIntegracao: String? = null,
    @SerializedName("codigo_cliente_omie")
    val codigoClienteOmie: String? = null
)
