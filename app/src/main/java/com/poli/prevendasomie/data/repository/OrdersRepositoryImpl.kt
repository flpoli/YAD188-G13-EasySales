package com.poli.prevendasomie.data.repository

import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.pedidos.ListarPedidosDto
import com.poli.prevendasomie.domain.repository.OrdersRepository
import javax.inject.Inject

class OrdersRepositoryImpl
@Inject constructor(private val api: OmieAPI) : OrdersRepository {

    override suspend fun getOrderList(request: Request.ListarPedidosRequest): ListarPedidosDto {

        return api.getOrderList(request)
    }
}
