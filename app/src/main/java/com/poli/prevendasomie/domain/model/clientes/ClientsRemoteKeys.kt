package com.poli.prevendasomie.domain.model.clientes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients_keys")
data class ClientsRemoteKeys(

    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long?

)
