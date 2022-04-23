package com.poli.prevendasomie.domain.model.produtos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_keys")
data class ProductsRemoteKeys(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?

)
