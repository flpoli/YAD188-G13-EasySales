package com.poli.prevendasomie.data.local.entities.pedidos

import com.google.gson.annotations.SerializedName

data class TotalPedidoEntity(
    @SerializedName("base_calculo_icms")
    val baseCalculoIcms: Int?,
    @SerializedName("base_calculo_st")
    val baseCalculoSt: Int?,
    @SerializedName("valor_cofins")
    val valorCofins: Int?,
    @SerializedName("valor_csll")
    val valorCsll: Int?,
    @SerializedName("valor_deducoes")
    val valorDeducoes: Int?,
    @SerializedName("valor_descontos")
    val valorDescontos: Int?,
    @SerializedName("valor_IPI")
    val valorIPI: Double?,
    @SerializedName("valor_icms")
    val valorIcms: Int?,
    @SerializedName("valor_inss")
    val valorInss: Int?,
    @SerializedName("valor_ir")
    val valorIr: Int?,
    @SerializedName("valor_iss")
    val valorIss: Int?,
    @SerializedName("valor_mercadorias")
    val valorMercadorias: Double?,
    @SerializedName("valor_pis")
    val valorPis: Int?,
    @SerializedName("valor_st")
    val valorSt: Int?,
    @SerializedName("valor_total_pedido")
    val valorTotalPedido: Double?
)
