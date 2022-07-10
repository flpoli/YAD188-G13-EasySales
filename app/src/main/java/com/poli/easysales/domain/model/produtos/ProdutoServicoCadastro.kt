package com.poli.easysales.domain.model.produtos

import android.os.Parcelable
import com.poli.easysales.data.remote.dto.produtos.Imagens
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProdutoServicoCadastro(

    val codigo: String? = null,
    val codigoProduto: Long,
    val codigoProdutoIntegracao: String? = null,
    val descricao: String? = null,
    val descrDetalhada: String? = null,
    val quantidadeEstoque: Int? = null,
    val unidade: String? = null,
    val valorUnitario: Double? = null,
    val descricaoFamilia: String? = null,
    val diasGarantia: Int? = null,
    val altura: Int? = null,
    val largura: Int? = null,
    val profundidade: Int? = null,
    val pesoBruto: Float? = null,
    val pesoLiq: Float? = null,
    val marca: String? = null,
    val modelo: String? = null,
    val obsInternas: String? = null,
    val imagens: List<Imagens>? = listOf(Imagens(""))

) : Parcelable
