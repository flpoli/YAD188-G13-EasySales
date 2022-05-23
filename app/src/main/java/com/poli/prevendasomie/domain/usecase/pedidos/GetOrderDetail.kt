package com.poli.prevendasomie.domain.usecase.pedidos

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto

interface GetOrderDetail {

    suspend operator fun invoke(orderId: Long): PedidoVendaProduto

}