package com.poli.easysales.data.local.entities.pedidos


data class ProdutoEntity(
    val cfop: String?,
    val cnpjFabricante: String?,
    val codigo: String?,
    val codigoProduto: Long?,
    val codigoTabelaPreco: Long?,
    val descricao: String?,
    val ean: String?,
    val indicadorEscala: String?,
    val motivoIcmsDesonerado: String?,
    val ncm: String?,
    val percentualDesconto: Double?,
    val quantidade: Int?,
    val reservado: String?,
    val tipoDesconto: String?,
    val unidade: String?,
    val valorDeducao: Double?,
    val valorDesconto: Double?,
    val valorIcmsDesonerado: Double?,
    val valorMercadoria: Double?,
    val valorTotal: Double?,
    val valorUnitario: Double?
)
