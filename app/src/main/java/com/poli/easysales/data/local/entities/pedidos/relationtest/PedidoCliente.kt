package com.poli.easysales.data.local.entities.pedidos.relationtest

import androidx.room.Embedded
import androidx.room.Relation

data class PedidoCliente(

    @Embedded val cliente: ClienteEntity,

    @Relation(
        parentColumn = "clientId",
        entityColumn = "orderId"
    )
    val pedido: PedidoVendaEntity,

)
