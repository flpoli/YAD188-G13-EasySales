package com.poli.prevendasomie.domain.usecase.products

import androidx.paging.PagingData
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsListUseCaseImpl
@Inject constructor(private val repository: ProductsRepository) : GetProductsListUseCase {

    override fun invoke(): Flow<PagingData<ProdutoServicoCadastro>>? {

        return repository.getProductList()
    }
}
