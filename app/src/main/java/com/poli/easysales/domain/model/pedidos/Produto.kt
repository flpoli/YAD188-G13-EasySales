package com.poli.easysales.domain.model.pedidos

data class Produto(
    val cfop: String? = "",
    val cnpjFabricante: String? = "",
    val codigo: String? = "",
    val codigoProduto: Long? = 0,
    val codigoTabelaPreco: Long? = 0,
    val descricao: String? = "",
    val ean: String? = "",
    val indicadorEscala: String? = "",
    val motivoIcmsDesonerado: String? = "",
    val ncm: String? = "",
    val percentualDesconto: Double? = 0.0,
    val quantidade: Int? = 0,
    val reservado: String? = "",
    val tipoDesconto: String? = "",
    val unidade: String? = "",
    val valorDeducao: Double? = 0.0,
    val valorDesconto: Double? = 0.0,
    val valorIcmsDesonerado: Double? = 0.0,
    val valorMercadoria: Double? = 0.0,
    val valorTotal: Double? = 0.0,
    val valorUnitario: Double? = 0.0
)
