package com.poli.easysales.domain.usecase.pedidos

import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

interface GetOrderDetail {

    suspend operator fun invoke(orderId: Long): PedidoVendaProduto
}
