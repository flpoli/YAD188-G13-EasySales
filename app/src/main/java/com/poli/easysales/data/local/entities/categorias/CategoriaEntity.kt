package com.poli.easysales.data.local.entities.categorias

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categorias")
data class CategoriaEntity (

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val codigo: String,
    val descricao: String

    )