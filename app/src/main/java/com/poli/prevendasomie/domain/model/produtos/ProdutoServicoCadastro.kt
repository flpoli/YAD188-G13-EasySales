package com.poli.prevendasomie.domain.model.produtos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_table")
data class ProdutoServicoCadastro(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val codigo: String?,
    val codigoProduto: Long,
    val codigoProdutoIntegracao: String?,
    val descricao: String?,
    val descrDetalhada: String?,
    val quantidadeEstoque: Int?,
    val unidade: String?,
    val valorUnitario: Double?,

)
