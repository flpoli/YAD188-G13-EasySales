package com.poli.prevendasomie.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class Produto(
    @SerializedName("cfop")
    val cfop: String? = "",
    @SerializedName("cnpj_fabricante")
    val cnpjFabricante: String? = "",
    @SerializedName("codigo")
    val codigo: String? = "",
    @SerializedName("codigo_produto")
    val codigoProduto: Long? = 0,
    @SerializedName("codigo_tabela_preco")
    val codigoTabelaPreco: Long? = 0,
    @SerializedName("descricao")
    val descricao: String? = "",
    @SerializedName("ean")
    val ean: String? = "",
    @SerializedName("indicador_escala")
    val indicadorEscala: String? = "",
    @SerializedName("motivo_icms_desonerado")
    val motivoIcmsDesonerado: String? = "",
    @SerializedName("ncm")
    val ncm: String? = "",
    @SerializedName("percentual_desconto")
    val percentualDesconto: Double? = 0.0,
    @SerializedName("quantidade")
    val quantidade: Int?,
    @SerializedName("reservado")
    val reservado: String? = "",
    @SerializedName("tipo_desconto")
    val tipoDesconto: String? = "",
    @SerializedName("unidade")
    val unidade: String? = "",
    @SerializedName("valor_deducao")
    val valorDeducao: Double? = 0.0,
    @SerializedName("valor_desconto")
    val valorDesconto: Double? = 0.0,
    @SerializedName("valor_icms_desonerado")
    val valorIcmsDesonerado: Double? = 0.0,
    @SerializedName("valor_mercadoria")
    val valorMercadoria: Double? = 0.0,
    @SerializedName("valor_total")
    val valorTotal: Double? = 0.0,
    @SerializedName("valor_unitario")
    val valorUnitario: Double? = 0.0
)
