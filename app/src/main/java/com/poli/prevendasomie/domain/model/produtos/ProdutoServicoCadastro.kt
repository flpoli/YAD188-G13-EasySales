package com.poli.prevendasomie.domain.model.produtos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poli.prevendasomie.common.Constants.PRODUCTS_TABLE
import com.poli.prevendasomie.data.remote.responses.produtos.Imagens

@Entity(tableName = PRODUCTS_TABLE)
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
    val imagens: List<Imagens>? = listOf(Imagens(""))

)
