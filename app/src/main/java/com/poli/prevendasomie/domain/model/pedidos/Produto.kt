package com.poli.prevendasomie.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class Produto(
    @SerializedName("cfop")
    val cfop: String?,
    @SerializedName("cnpj_fabricante")
    val cnpjFabricante: String?,
    @SerializedName("codigo")
    val codigo: String?,
    @SerializedName("codigo_produto")
    val codigoProduto: Int?,
    @SerializedName("codigo_tabela_preco")
    val codigoTabelaPreco: Int?,
    @SerializedName("descricao")
    val descricao: String?,
    @SerializedName("ean")
    val ean: String?,
    @SerializedName("indicador_escala")
    val indicadorEscala: String?,
    @SerializedName("motivo_icms_desonerado")
    val motivoIcmsDesonerado: String?,
    @SerializedName("ncm")
    val ncm: String?,
    @SerializedName("percentual_desconto")
    val percentualDesconto: Double?,
    @SerializedName("quantidade")
    val quantidade: Int?,
    @SerializedName("reservado")
    val reservado: String?,
    @SerializedName("tipo_desconto")
    val tipoDesconto: String?,
    @SerializedName("unidade")
    val unidade: String?,
    @SerializedName("valor_deducao")
    val valorDeducao: Int?,
    @SerializedName("valor_desconto")
    val valorDesconto: Int?,
    @SerializedName("valor_icms_desonerado")
    val valorIcmsDesonerado: Int?,
    @SerializedName("valor_mercadoria")
    val valorMercadoria: Double?,
    @SerializedName("valor_total")
    val valorTotal: Double?,
    @SerializedName("valor_unitario")
    val valorUnitario: Double?
)
