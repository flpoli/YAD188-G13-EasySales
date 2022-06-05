package com.poli.easysales.domain.model.produtos

data class ListarProdutos(

    val pagina: Int,
    val produtoServicoCadastro: List<ProdutoServicoCadastro>,
    val registros: Int?,
    val totalDePaginas: Int?,
    val totalDeRegistros: Int?
)
