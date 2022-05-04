package com.poli.prevendasomie.data.local.entities.pedidos

import com.google.gson.annotations.SerializedName

data class TotalPedidoEntity(
    @SerializedName("base_calculo_icms")
    val baseCalculoIcms: Double?,
    @SerializedName("base_calculo_st")
    val baseCalculoSt: Double?,
    @SerializedName("valor_cofins")
    val valorCofins: Double?,
    @SerializedName("valor_csll")
    val valorCsll: Double?,
    @SerializedName("valor_deducoes")
    val valorDeducoes: Double?,
    @SerializedName("valor_descontos")
    val valorDescontos: Double?,
    @SerializedName("valor_IPI")
    val valorIPI: Double?,
    @SerializedName("valor_icms")
    val valorIcms: Double?,
    @SerializedName("valor_inss")
    val valorInss: Double?,
    @SerializedName("valor_ir")
    val valorIr: Double?,
    @SerializedName("valor_iss")
    val valorIss: Double?,
    @SerializedName("valor_mercadorias")
    val valorMercadorias: Double?,
    @SerializedName("valor_pis")
    val valorPis: Double?,
    @SerializedName("valor_st")
    val valorSt: Double?,
    @SerializedName("valor_total_pedido")
    val valorTotalPedido: Double?
)
