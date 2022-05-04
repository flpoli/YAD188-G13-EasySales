package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.data.local.entities.pedidos.InformacoesAdicionaisEntity
import com.poli.prevendasomie.domain.model.pedidos.InformacoesAdicionais

data class InformacoesAdicionaisDto(
    @SerializedName("codProj")
    val codProj: Long?,
    @SerializedName("codVend")
    val codVend: Long?,
    @SerializedName("codigo_categoria")
    val codigoCategoria: String?,
    @SerializedName("codigo_conta_corrente")
    val codigoContaCorrente: Long?,
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

fun InformacoesAdicionaisDto.toInformacoesAdicionais(): InformacoesAdicionais {

    return InformacoesAdicionais(
        codProj = codProj,
        codVend = codVend,
        codigoCategoria = codigoCategoria,
        codigoContaCorrente = codigoContaCorrente,
        consumidorFinal = consumidorFinal,
        contato = contato,
        dadosAdicionaisNf = dadosAdicionaisNf,
        enviarEmail = enviarEmail,
        numeroContrato = numeroContrato,
        numeroPedidoCliente = numeroPedidoCliente,
        //outrosDetalhes = outrosDetalhes,
        utilizarEmails = utilizarEmails
    )
}

fun InformacoesAdicionaisDto.toInformacoesAdicionaisEntity(): InformacoesAdicionaisEntity {

    return InformacoesAdicionaisEntity(
        infoId = 0,
        orderId = 0,
        codProj = codProj,
        codVend = codVend,
        codigoCategoria = codigoCategoria,
        codigoContaCorrente = codigoContaCorrente,
        consumidorFinal = consumidorFinal,
        contato = contato,
        dadosAdicionaisNf = dadosAdicionaisNf,
        enviarEmail = enviarEmail,
        numeroContrato = numeroContrato,
        numeroPedidoCliente = numeroPedidoCliente,
        utilizarEmails = utilizarEmails
    )
}
