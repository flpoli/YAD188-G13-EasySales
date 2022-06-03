package com.poli.prevendasomie.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_keys")
data class ProductsRemoteKeys(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?

)
