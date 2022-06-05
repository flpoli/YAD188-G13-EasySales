package com.poli.easysales.domain.usecase.pedidos

import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.repository.OrdersRepository
import javax.inject.Inject

class GetOrderDetailImpl @Inject constructor(private val repository: OrdersRepository) : GetOrderDetail {
    override suspend fun invoke(orderId: Long): PedidoVendaProduto {

        return repository.getOrderById(orderId)
    }
}
