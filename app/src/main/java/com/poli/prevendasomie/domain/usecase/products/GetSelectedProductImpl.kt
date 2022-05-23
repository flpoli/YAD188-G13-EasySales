package com.poli.prevendasomie.domain.usecase.products

import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.domain.repository.ProductsRepository
import javax.inject.Inject

class GetSelectedProductImpl @Inject constructor(private val repository: ProductsRepository) : GetSelectedProduct {
    override suspend fun invoke(productId: Long): ProdutoServicoCadastro {

        return repository.getSelectedProduct(productId = productId)
    }
}
