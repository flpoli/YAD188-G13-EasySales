package com.poli.prevendasomie.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class TotalPedido(
    @SerializedName("base_calculo_icms")
    val baseCalculoIcms: Double? = 0.0,
    @SerializedName("base_calculo_st")
    val baseCalculoSt: Double? = 0.0,
    @SerializedName("valor_cofins")
    val valorCofins: Double? = 0.0,
    @SerializedName("valor_csll")
    val valorCsll: Double? = 0.0,
    @SerializedName("valor_deducoes")
    val valorDeducoes: Double? = 0.0,
    @SerializedName("valor_descontos")
    val valorDescontos: Double? = 0.0,
    @SerializedName("valor_IPI")
    val valorIPI: Double? = 0.0,
    @SerializedName("valor_icms")
    val valorIcms: Double? = 0.0,
    @SerializedName("valor_inss")
    val valorInss: Double? = 0.0,
    @SerializedName("valor_ir")
    val valorIr: Double? = 0.0,
    @SerializedName("valor_iss")
    val valorIss: Double? = 0.0,
    @SerializedName("valor_mercadorias")
    val valorMercadorias: Double? = 0.0,
    @SerializedName("valor_pis")
    val valorPis: Double? = 0.0,
    @SerializedName("valor_st")
    val valorSt: Double? = 0.0,
    @SerializedName("valor_total_pedido")
    val valorTotalPedido: Double? = 0.0
)
