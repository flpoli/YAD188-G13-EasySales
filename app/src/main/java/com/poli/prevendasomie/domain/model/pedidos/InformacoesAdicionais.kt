package com.poli.prevendasomie.domain.model.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.data.remote.responses.pedidos.OutrosDetalhesDto

data class InformacoesAdicionais(
    @SerializedName("codProj")
    val codProj: Int?,
    @SerializedName("codVend")
    val codVend: Int?,
    @SerializedName("codigo_categoria")
    val codigoCategoria: String?,
    @SerializedName("codigo_conta_corrente")
    val codigoContaCorrente: Int?,
    @SerializedName("consumidor_final")
    val consumidorFinal: String?,
    @SerializedName("contato")
    val contato: String?,
    @SerializedName("dados_adicionais_nf")
    val dadosAdicionaisNf: String?,
    @SerializedName("enviar_email")
    val enviarEmail: String?,
    @SerializedName("numero_contrato")
    val numeroContrato: String?,
    @SerializedName("numero_pedido_cliente")
    val numeroPedidoCliente: String?,
    @SerializedName("outros_detalhes")
    val outrosDetalhes: OutrosDetalhesDto?,
    @SerializedName("utilizar_emails")
    val utilizarEmails: String?
)
