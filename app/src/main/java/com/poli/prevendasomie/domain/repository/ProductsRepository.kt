package com.poli.prevendasomie.domain.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.produtos.ProdutoServicoCadastroDto
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

     fun getProductList(): Flow<PagingData<ProdutoServicoCadastro>>?
}
