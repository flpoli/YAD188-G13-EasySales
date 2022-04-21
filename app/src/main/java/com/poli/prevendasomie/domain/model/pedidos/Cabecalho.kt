package com.poli.prevendasomie.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class Cabecalho(
    @SerializedName("bloqueado")
    val bloqueado: String?,
    @SerializedName("codigo_cenario_impostos")
    val codigoCenarioImpostos: String?,
    @SerializedName("codigo_cliente")
    val codigoCliente: Int?,
    @SerializedName("codigo_empresa")
    val codigoEmpresa: Int?,
    @SerializedName("codigo_parcela")
    val codigoParcela: String?,
    @SerializedName("codigo_pedido")
    val codigoPedido: Int?,
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
