package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.produtos.ListarProdutosDto

interface ProductsRepository {

    suspend fun getProductList(request: Request.ListarProdutosRequest): ListarProdutosDto
}
