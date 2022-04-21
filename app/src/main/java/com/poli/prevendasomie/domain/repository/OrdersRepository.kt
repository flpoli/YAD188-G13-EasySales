package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.pedidos.ListarPedidosDto

interface OrdersRepository {

    suspend fun getOrderList(request: Request.ListarPedidosRequest): ListarPedidosDto
}
