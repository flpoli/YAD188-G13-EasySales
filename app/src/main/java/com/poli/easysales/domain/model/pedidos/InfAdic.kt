package com.poli.easysales.domain.model.pedidos

import com.google.gson.annotations.SerializedName

data class InfAdic(
    val codigoCategoriaItem: String? = "",
    val codigoCenarioImpostosItem: String? = "",
    val codigoLocalEstoque: Long? = 0,
    val dadosAdicionaisItem: String? = "",
    val itemPedidoCompra: Long? = 0,
    val naoGerarFinanceiro: String? = "",
    val naoMovimentarEstoque: String? = "",
    val numeroPedidoCompra: String? = "",
    val pesoBruto: Double? = 0.0,
    val pesoLiquido: Double? = 0.0
)
