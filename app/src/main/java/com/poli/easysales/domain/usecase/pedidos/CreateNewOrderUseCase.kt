package com.poli.easysales.domain.usecase.pedidos

import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

interface CreateNewOrderUseCase {

     operator fun invoke(order: PedidoVendaProduto)


}