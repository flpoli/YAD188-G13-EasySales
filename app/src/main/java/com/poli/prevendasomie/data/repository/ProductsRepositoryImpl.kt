package com.poli.prevendasomie.data.repository

import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.produtos.ListarProdutosDto
import com.poli.prevendasomie.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl
@Inject constructor(private val api: OmieAPI) : ProductsRepository {

    override suspend fun getProductList(request: Request.ListarProdutosRequest): ListarProdutosDto {

        return api.getProductList(request)
    }
}
