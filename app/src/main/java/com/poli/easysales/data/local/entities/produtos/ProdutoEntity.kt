package com.poli.easysales.data.local.entities.produtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poli.easysales.common.Constants.PRODUCTS_TABLE
import com.poli.easysales.data.remote.dto.produtos.Imagens

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
    val descricaoFamilia: String?,
    val diasGarantia: Int?,
    val altura: Int?,
    val largura: Int?,
    val profundidade: Int?,
    val pesoBruto: Float?,
    val pesoLiq: Float?,
    val marca: String?,
    val modelo: String?,
    val obsInternas: String?,
    val imagens: List<Imagens>? = listOf(Imagens(""))

)
