package com.poli.easysales.domain.usecase.pedidos

import com.poli.easysales.data.local.entities.produtos.ProdutoVendaEntity
import com.poli.easysales.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductListForSelectionImpl
@Inject constructor(private val repository: ProductsRepository) : GetProductListForSelection {
    override fun invoke(): Flow<List<ProdutoVendaEntity>> {

        return repository.getProductsForSelection()
    }
}
