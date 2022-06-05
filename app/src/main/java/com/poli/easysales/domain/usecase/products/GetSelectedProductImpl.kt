package com.poli.easysales.domain.usecase.products

import com.poli.easysales.data.local.entities.produtos.ProdutoEntity
import com.poli.easysales.domain.repository.ProductsRepository
import javax.inject.Inject

class GetSelectedProductImpl @Inject constructor(private val repository: ProductsRepository) : GetSelectedProduct {
    override suspend fun invoke(productId: Long): ProdutoEntity {

        return repository.getSelectedProduct(productId = productId)
    }
}
