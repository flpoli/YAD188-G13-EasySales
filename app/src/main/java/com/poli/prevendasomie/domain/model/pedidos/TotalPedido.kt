package com.poli.prevendasomie.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class TotalPedido(
    @SerializedName("base_calculo_icms")
    val baseCalculoIcms: Int? = 0,
    @SerializedName("base_calculo_st")
    val baseCalculoSt: Int? = 0,
    @SerializedName("valor_cofins")
    val valorCofins: Int? = 0,
    @SerializedName("valor_csll")
    val valorCsll: Int? = 0,
    @SerializedName("valor_deducoes")
    val valorDeducoes: Int? = 0,
    @SerializedName("valor_descontos")
    val valorDescontos: Int? = 0,
    @SerializedName("valor_IPI")
    val valorIPI: Double? = 0.0,
    @SerializedName("valor_icms")
    val valorIcms: Int? = 0,
    @SerializedName("valor_inss")
    val valorInss: Int? = 0,
    @SerializedName("valor_ir")
    val valorIr: Int? = 0,
    @SerializedName("valor_iss")
    val valorIss: Int? = 0,
    @SerializedName("valor_mercadorias")
    val valorMercadorias: Double? = 0.0,
    @SerializedName("valor_pis")
    val valorPis: Int? = 0,
    @SerializedName("valor_st")
    val valorSt: Int? = 0,
    @SerializedName("valor_total_pedido")
    val valorTotalPedido: Double? = 0.0
)
