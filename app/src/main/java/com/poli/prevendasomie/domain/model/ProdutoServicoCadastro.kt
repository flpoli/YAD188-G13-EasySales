package com.poli.prevendasomie.domain.model

data class ProdutoServicoCadastro(

    val codigo: String?,
    val codigoProduto: Long?,
    val codigoProdutoIntegracao: String?,
    val descricao: String?,
    val descrDetalhada: String?,
    val quantidadeEstoque: Int?,
    val unidade: String?,
    val valorUnitario: Double?,

)
