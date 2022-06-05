package com.poli.easysales.data.local.entities.pedidos.relationtest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders_table_test")
data class PedidoVendaEntity(

    @PrimaryKey(autoGenerate = true)
    val orderId: Int,
    val clientId: Int

)
