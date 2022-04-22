package com.poli.prevendasomie.domain.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.produtos.ListarProdutosDto
import com.poli.prevendasomie.data.remote.responses.produtos.ProdutoServicoCadastroDto
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    suspend fun getProductList(request: Request.ListarProdutosRequest): Flow<PagingData<ProdutoServicoCadastroDto>>
}
