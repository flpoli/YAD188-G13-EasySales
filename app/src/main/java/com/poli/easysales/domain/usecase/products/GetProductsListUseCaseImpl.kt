package com.poli.easysales.domain.usecase.products

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.produtos.ProdutoEntity
import com.poli.easysales.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsListUseCaseImpl
@Inject constructor(private val repository: ProductsRepository) : GetProductsListUseCase {

    override fun invoke(): Flow<PagingData<ProdutoEntity>>? {

        return repository.getProductList()
    }
}