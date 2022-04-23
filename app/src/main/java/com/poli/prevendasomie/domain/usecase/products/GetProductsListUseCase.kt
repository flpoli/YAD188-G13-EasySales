package com.poli.prevendasomie.domain.usecase.products

import androidx.paging.PagingData
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.responses.produtos.ListarProdutosDto
import com.poli.prevendasomie.data.remote.responses.produtos.ProdutoServicoCadastroDto
import com.poli.prevendasomie.domain.model.produtos.ListarProdutos
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import kotlinx.coroutines.flow.Flow

interface GetProductsListUseCase {

    operator fun invoke(): Flow<PagingData<ProdutoServicoCadastro>>?
}
