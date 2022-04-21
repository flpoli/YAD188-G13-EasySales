package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.domain.model.pedidos.TotalPedido

data class TotalPedidoDto(
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

fun TotalPedidoDto.toTotalPedido(): TotalPedido {

    return TotalPedido(
        baseCalculoIcms = baseCalculoIcms,
        baseCalculoSt = baseCalculoSt,
        valorCofins = valorCofins,
        valorCsll = valorCsll,
        valorDeducoes = valorDeducoes,
        valorDescontos = valorDescontos,
        valorIPI = valorIPI,
        valorIcms = valorIcms,
        valorInss = valorInss,
        valorIr = valorIr,
        valorIss = valorIss,
        valorMercadorias = valorMercadorias,
        valorPis = valorPis,
        valorSt = valorSt,
        valorTotalPedido = valorTotalPedido
    )
}
