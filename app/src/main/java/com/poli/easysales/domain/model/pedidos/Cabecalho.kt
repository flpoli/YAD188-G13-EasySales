package com.poli.easysales.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class Cabecalho(
    @SerializedName("bloqueado")
    val bloqueado: String? = "N",
    @SerializedName("codigo_cenario_impostos")
    val codigoCenarioImpostos: String? = "",
    @SerializedName("codigo_cliente")
    val codigoCliente: Long? = 0,
    @SerializedName("codigo_empresa")
    val codigoEmpresa: Long? = 0,
    @SerializedName("codigo_parcela")
    val codigoParcela: String? = "",
    @SerializedName("codigo_pedido")
    val codigoPedido: Long? = 0,
    @SerializedName("codigo_pedido_integracao")
    val codigoPedidoIntegracao: String? = "",
    @SerializedName("data_previsao")
    val dataPrevisao: String? = "",
    @SerializedName("etapa")
    val etapa: String? = "",
    @SerializedName("importado_api")
    val importadoApi: String? = "",
    @SerializedName("numero_pedido")
    val numeroPedido: String? = "",
    @SerializedName("origem_pedido")
    val origemPedido: String? = "",
    @SerializedName("qtde_parcelas")
    val qtdeParcelas: Int? = 0,
    @SerializedName("quantidade_itens")
    val quantidadeItens: Int? = 0

)
