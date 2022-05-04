package com.poli.prevendasomie.data.local.entities.pedidos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cabecalho_entity")
data class CabecalhoEntity(

    @PrimaryKey(autoGenerate = true)
    val cabecalhoId: Int,
    val orderId: Int,

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
