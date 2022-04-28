package com.poli.prevendasomie.data.local.entities.pedidos

data class CabecalhoEntity(

    val bloqueado: String?,
    val codigoCenarioImpostos: String?,
    val codigoCliente: Int?,
    val codigoEmpresa: Int?,
    val codigoParcela: String?,
    val codigoPedido: Int?,
    val codigoPedidoIntegracao: String?,
    val dataPrevisao: String?,
    val etapa: String?,
    val importadoApi: String?,
    val numeroPedido: String?,
    val origemPedido: String?,
    val qtdeParcelas: Int?,
    val quantidadeItens: Int?

)
