package com.poli.prevendasomie.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.poli.prevendasomie.data.pagingsource.ProductsSearchSource
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.produtos.ListarProdutosDto
import com.poli.prevendasomie.data.remote.responses.produtos.ProdutoServicoCadastroDto
import com.poli.prevendasomie.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl
@Inject constructor(private val api: OmieAPI) : ProductsRepository {

    override suspend fun getProductList(request: Request.ListarProdutosRequest): Flow<PagingData<ProdutoServicoCadastroDto>> {
        api.getProductList(request)


        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { ProductsSearchSource(api, request) }
        ).flow
    }
}
