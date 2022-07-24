package com.poli.easysales.data.local.entities.pedidos.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.poli.easysales.data.local.entities.pedidos.Det
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

data class OrderWithDets(

    @Embedded val pedido: PedidoVendaProduto,

    @Relation(
        parentColumn = "det",
        entityColumn = "id"
    )
    val det: List<Det>
)