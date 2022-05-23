package com.poli.prevendasomie.domain.usecase.pedidos

import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductListForSelectionImpl
    @Inject constructor(private val repository: ProductsRepository): GetProductListForSelection {
    override fun invoke(): Flow<List<ProdutoServicoCadastro>> {


        return repository.getProductsForSelection()
    }
}