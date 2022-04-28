package com.poli.prevendasomie.domain.usecase.pedidos

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import com.poli.prevendasomie.domain.repository.OrdersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOrdersListUseCaseImpl
@Inject constructor(private val repository: OrdersRepository) : GetOrdersListUseCase {
    override fun invoke(): Flow<Resource<PedidoVendaProduto>> {

        return repository.getOrdersList()
    }
}
