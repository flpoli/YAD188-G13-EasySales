package com.poli.prevendasomie.domain.model.produtos

import android.os.Parcelable
import com.poli.prevendasomie.data.remote.dto.produtos.Imagens
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
    val imagens: List<Imagens>? = listOf(Imagens(""))

): Parcelable
