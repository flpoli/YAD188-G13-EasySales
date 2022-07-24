package com.poli.easysales.domain.usecase.pedidos

import com.poli.easysales.domain.repository.OrdersRepository
import javax.inject.Inject

class InsertProductsOnOrderUseCase @Inject constructor(private val repository: OrdersRepository) {

    suspend operator fun invoke(orderId: Int, codigoProduto: Long, quantidade: Int, valorUnitario: Double) {

//        repository.addProdutoOnOrder(orderId, codigoProduto, quantidade, valorUnitario)

    }
}