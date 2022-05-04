package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.domain.model.pedidos.Produto

data class ProdutoDto(
    @SerializedName("cfop")
    val cfop: String?,
    @SerializedName("cnpj_fabricante")
    val cnpjFabricante: String?,
    @SerializedName("codigo")
    val codigo: String?,
    @SerializedName("codigo_produto")
    val codigoProduto: Long?,
    @SerializedName("codigo_tabela_preco")
    val codigoTabelaPreco: Long?,
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
    val valorDeducao: Double?,
    @SerializedName("valor_desconto")
    val valorDesconto: Double?,
    @SerializedName("valor_icms_desonerado")
    val valorIcmsDesonerado: Double?,
    @SerializedName("valor_mercadoria")
    val valorMercadoria: Double?,
    @SerializedName("valor_total")
    val valorTotal: Double?,
    @SerializedName("valor_unitario")
    val valorUnitario: Double?
)

fun ProdutoDto.toProduto(): Produto {

    return Produto(
        cfop = cfop,
        cnpjFabricante = cnpjFabricante,
        codigo = codigo,
        codigoProduto = codigoProduto,
        codigoTabelaPreco = codigoTabelaPreco,
        descricao = descricao,
        ean = ean,
        indicadorEscala = indicadorEscala,
        motivoIcmsDesonerado = motivoIcmsDesonerado,
        ncm = ncm,
        percentualDesconto = percentualDesconto,
        quantidade = quantidade,
        reservado = reservado,
        tipoDesconto = tipoDesconto,
        unidade = unidade,
        valorDeducao = valorDeducao,
        valorDesconto = valorDesconto,
        valorIcmsDesonerado = valorIcmsDesonerado,
        valorMercadoria = valorMercadoria,
        valorTotal = valorTotal,
        valorUnitario = valorUnitario
    )
}
