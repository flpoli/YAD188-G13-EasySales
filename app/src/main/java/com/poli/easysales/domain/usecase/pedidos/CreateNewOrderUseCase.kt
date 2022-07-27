package com.poli.easysales.domain.usecase.pedidos

import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

interface CreateNewOrderUseCase {

     suspend operator fun invoke(order: List<PedidoVendaProduto>)


}