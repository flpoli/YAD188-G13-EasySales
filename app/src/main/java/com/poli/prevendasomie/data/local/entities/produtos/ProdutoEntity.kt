package com.poli.prevendasomie.data.local.entities.produtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poli.prevendasomie.common.Constants.PRODUCTS_TABLE
import com.poli.prevendasomie.data.remote.dto.produtos.Imagens

@Entity(PRODUCTS_TABLE)
data class ProdutoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val codigo: String?,
    val codigoProduto: Long,
    val codigoProdutoIntegracao: String?,
    val descricao: String?,
    val descrDetalhada: String?,
    val quantidadeEstoque: Int?,
    val unidade: String?,
    val valorUnitario: Double?,
    val imagens: List<Imagens>? = listOf(Imagens(""))

)
