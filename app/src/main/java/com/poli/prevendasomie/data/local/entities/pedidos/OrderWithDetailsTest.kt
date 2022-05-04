package com.poli.prevendasomie.data.local.entities.pedidos

import androidx.room.Embedded
import androidx.room.Relation
import com.poli.prevendasomie.domain.model.pedidos.Cabecalho

data class OrderWithDetailsTest(


    val orderId: Int,
    val pedidoVenda: PedidoVendaEntity,

    @Relation(
        parentColumn = "orderId",
        entityColumn = "cabecalhoId"
    )
    val cabecalho: CabecalhoEntity,

    @Relation(
        parentColumn = "orderId",
        entityColumn = "freteId"
    )
    val frete: FreteEntity,

    @Relation(
        parentColumn = "orderId",
        entityColumn = "infoCadastroId"
    )
    val infoCadastro: InfoCadastroEntity


)
