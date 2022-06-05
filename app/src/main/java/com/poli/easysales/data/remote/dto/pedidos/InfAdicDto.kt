package com.poli.easysales.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.easysales.domain.model.pedidos.InfAdic

data class InfAdicDto(
    @SerializedName("codigo_categoria_item")
    val codigoCategoriaItem: String?,
    @SerializedName("codigo_cenario_impostos_item")
    val codigoCenarioImpostosItem: String?,
    @SerializedName("codigo_local_estoque")
    val codigoLocalEstoque: Long?,
    @SerializedName("dados_adicionais_item")
    val dadosAdicionaisItem: String?,
    @SerializedName("item_pedido_compra")
    val itemPedidoCompra: Long?,
    @SerializedName("nao_gerar_financeiro")
    val naoGerarFinanceiro: String?,
    @SerializedName("nao_movimentar_estoque")
    val naoMovimentarEstoque: String?,
    @SerializedName("numero_pedido_compra")
    val numeroPedidoCompra: String?,
    @SerializedName("peso_bruto")
    val pesoBruto: Double?,
    @SerializedName("peso_liquido")
    val pesoLiquido: Double?
)

fun InfAdicDto.toInfAdic(): InfAdic {

    return InfAdic(
        codigoCategoriaItem = codigoCategoriaItem,
        codigoCenarioImpostosItem = codigoCenarioImpostosItem,
        codigoLocalEstoque = codigoLocalEstoque,
        dadosAdicionaisItem = dadosAdicionaisItem,
        itemPedidoCompra = itemPedidoCompra,
        naoGerarFinanceiro = naoGerarFinanceiro,
        naoMovimentarEstoque = naoMovimentarEstoque,
        numeroPedidoCompra = numeroPedidoCompra,
        pesoBruto = pesoBruto,
        pesoLiquido = pesoLiquido
    )
}
