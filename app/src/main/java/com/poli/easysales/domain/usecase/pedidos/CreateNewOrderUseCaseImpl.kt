package com.poli.easysales.domain.usecase.pedidos

import com.poli.easysales.data.remote.Request
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.repository.OrdersRepository
import javax.inject.Inject

class CreateNewOrderUseCaseImpl @Inject constructor(private val repository: OrdersRepository) {

    suspend operator fun invoke(order: PedidoVendaProduto){


        val request = Request.IncluirPedidosRequest(param = order)

        repository.insertNewOrder(request)

    }
}