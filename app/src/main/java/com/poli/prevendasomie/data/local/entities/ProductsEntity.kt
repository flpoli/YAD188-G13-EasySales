package com.poli.prevendasomie.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produtos")
data class ProductsEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val codigo: String?,
    val codigoProduto: Long,
    val codigoProdutoIntegracao: String?,
    val descricao: String?,
    val descrDetalhada: String?,
    val quantidadeEstoque: Int?,
    val unidade: String?,
    val valorUnitario: Double?,
)
