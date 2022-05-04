package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.data.local.entities.pedidos.CabecalhoEntity
import com.poli.prevendasomie.domain.model.pedidos.Cabecalho

data class CabecalhoDto(
    @SerializedName("bloqueado")
    val bloqueado: String?,
    @SerializedName("codigo_cenario_impostos")
    val codigoCenarioImpostos: String?,
    @SerializedName("codigo_cliente")
    val codigoCliente: Long?,
    @SerializedName("codigo_empresa")
    val codigoEmpresa: Long?,
    @SerializedName("codigo_parcela")
    val codigoParcela: String?,
    @SerializedName("codigo_pedido")
    val codigoPedido: Long?,
    @SerializedName("codigo_pedido_integracao")
    val codigoPedidoIntegracao: String?,
    @SerializedName("data_previsao")
    val dataPrevisao: String?,
    @SerializedName("etapa")
    val etapa: String?,
    @SerializedName("importado_api")
    val importadoApi: String?,
    @SerializedName("numero_pedido")
    val numeroPedido: String?,
    @SerializedName("origem_pedido")
    val origemPedido: String?,
    @SerializedName("qtde_parcelas")
    val qtdeParcelas: Int?,
    @SerializedName("quantidade_itens")
    val quantidadeItens: Int?
)

fun CabecalhoDto.toCabecalho(): Cabecalho {

    return Cabecalho(
        bloqueado = bloqueado,
        codigoCenarioImpostos = codigoCenarioImpostos,
        codigoCliente = codigoCliente,
        codigoEmpresa = codigoEmpresa,
        codigoParcela = codigoParcela,
        codigoPedido = codigoPedido,
        codigoPedidoIntegracao = codigoPedidoIntegracao,
        dataPrevisao = dataPrevisao,
        etapa = etapa,
        importadoApi = importadoApi,
        numeroPedido = numeroPedido,
        origemPedido = origemPedido,
        qtdeParcelas = qtdeParcelas,
        quantidadeItens = quantidadeItens
    )
}

fun CabecalhoDto.toCabecalhoEntity(): CabecalhoEntity {

    return CabecalhoEntity(
        cabecalhoId = 0,
        orderId = 0,
        bloqueado = bloqueado,
        codigoCenarioImpostos = codigoCenarioImpostos,
        codigoCliente = codigoCliente,
        codigoEmpresa = codigoEmpresa,
        codigoParcela = codigoParcela,
        codigoPedido = codigoPedido,
        codigoPedidoIntegracao = codigoPedidoIntegracao,
        dataPrevisao = dataPrevisao,
        etapa = etapa,
        importadoApi = importadoApi,
        numeroPedido = numeroPedido,
        origemPedido = origemPedido,
        qtdeParcelas = qtdeParcelas,
        quantidadeItens = quantidadeItens
    )
}
