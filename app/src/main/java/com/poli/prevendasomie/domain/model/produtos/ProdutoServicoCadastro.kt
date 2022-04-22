package com.poli.prevendasomie.domain.model.produtos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produtos_table")
data class ProdutoServicoCadastro(


    val codigo: String?,

    @PrimaryKey(autoGenerate = false)
    val codigoProduto: Long,

    val codigoProdutoIntegracao: String?,
    val descricao: String?,
    val descrDetalhada: String?,
    val quantidadeEstoque: Int?,
    val unidade: String?,
    val valorUnitario: Double?,

)
