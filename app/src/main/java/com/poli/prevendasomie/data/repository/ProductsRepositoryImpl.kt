package com.poli.prevendasomie.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.poli.prevendasomie.data.pagingsource.ProductsSearchSource
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.produtos.ProdutoServicoCadastroDto
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.domain.repository.ProductsRepository
import com.poli.prevendasomie.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl
@Inject constructor(private val remote: RemoteDataSource) : ProductsRepository {

    override  fun getProductList(): Flow<PagingData<ProdutoServicoCadastro>> {


        return remote.getAllProducts()
    }
}
