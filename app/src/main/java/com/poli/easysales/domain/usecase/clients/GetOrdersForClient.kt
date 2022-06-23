package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto

interface GetOrdersForClient {

    suspend operator fun invoke(codigoCliente: Long): List<PedidoVendaProduto>
}
