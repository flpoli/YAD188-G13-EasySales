package com.poli.easysales.data.local.entities.pedidos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders_keys")
data class OrdersRemoteKeys(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?
)
