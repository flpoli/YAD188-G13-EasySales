package com.poli.easysales.data.local.entities.pedidos

data class InformacoesAdicionaisEntity(

    val codProj: Long?,
    val codVend: Long?,
    val codigoCategoria: String?,
    val codigoContaCorrente: Long?,
    val consumidorFinal: String?,
    val contato: String?,
    val dadosAdicionaisNf: String?,
    val enviarEmail: String?,
    val numeroContrato: String?,
    val numeroPedidoCliente: String?,
    // val outrosDetalhes: OutrosDetalhes?,
    val utilizarEmails: String?
)
