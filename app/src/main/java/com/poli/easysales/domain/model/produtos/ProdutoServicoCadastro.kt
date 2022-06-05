package com.poli.easysales.domain.model.produtos

import android.os.Parcelable
import com.poli.easysales.data.remote.dto.produtos.Imagens
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProdutoServicoCadastro(

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

) : Parcelable
