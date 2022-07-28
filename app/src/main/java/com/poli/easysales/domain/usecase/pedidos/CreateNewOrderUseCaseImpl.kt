package com.poli.easysales.domain.usecase.pedidos

import com.poli.easysales.data.remote.Request
import com.poli.easysales.domain.mappers.toPedidoDto
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.repository.OrdersRepository
import javax.inject.Inject

class CreateNewOrderUseCaseImpl @Inject constructor(private val repository: OrdersRepository) : CreateNewOrderUseCase {

    override suspend operator fun invoke(order: List<PedidoVendaProduto>) {

        val mapperdOrder = order.map { it.toPedidoDto() }
        val request = Request.IncluirPedidosRequest(param = mapperdOrder)

        repository.insertNewOrder(request)
    }
}
