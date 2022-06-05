package com.poli.easysales.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class InformacoesAdicionais(
    @SerializedName("codProj")
    val codProj: Long? = 0,
    @SerializedName("codVend")
    val codVend: Long? = 0,
    @SerializedName("codigo_categoria")
    val codigoCategoria: String? = "",
    @SerializedName("codigo_conta_corrente")
    val codigoContaCorrente: Long? = 0,
    @SerializedName("consumidor_final")
    val consumidorFinal: String? = "",
    @SerializedName("contato")
    val contato: String? = "",
    @SerializedName("dados_adicionais_nf")
    val dadosAdicionaisNf: String? = "",
    @SerializedName("enviar_email")
    val enviarEmail: String? = "",
    @SerializedName("numero_contrato")
    val numeroContrato: String? = "",
    @SerializedName("numero_pedido_cliente")
    val numeroPedidoCliente: String? = "",
    @SerializedName("outros_detalhes")
    val outrosDetalhes: OutrosDetalhes? = OutrosDetalhes(),
    @SerializedName("utilizar_emails")
    val utilizarEmails: String? = ""
)
