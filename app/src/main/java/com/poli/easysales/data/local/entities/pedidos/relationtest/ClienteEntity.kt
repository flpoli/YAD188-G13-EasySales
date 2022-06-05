package com.poli.easysales.data.local.entities.pedidos.relationtest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "client_table_test")
data class ClienteEntity(

    @PrimaryKey(autoGenerate = true)
    val clientId: Int,
    val nome: String

)
