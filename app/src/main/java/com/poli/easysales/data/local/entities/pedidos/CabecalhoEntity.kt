package com.poli.easysales.data.local.entities.pedidos

data class CabecalhoEntity(

    val bloqueado: String?,
    val codigoCenarioImpostos: String?,
    val codigoCliente: Long?,
    val codigoEmpresa: Long?,
    val codigoParcela: String?,
    val codigoPedido: Long?,
    val codigoPedidoIntegracao: String?,
    val dataPrevisao: String?,
    val etapa: String?,
    val importadoApi: String?,
    val numeroPedido: String?,
    val origemPedido: String?,
    val qtdeParcelas: Int?,
    val quantidadeItens: Int?

)
