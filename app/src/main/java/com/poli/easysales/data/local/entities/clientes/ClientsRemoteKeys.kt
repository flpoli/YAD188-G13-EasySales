package com.poli.easysales.data.local.entities.clientes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients_keys")
data class ClientsRemoteKeys(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?

)
