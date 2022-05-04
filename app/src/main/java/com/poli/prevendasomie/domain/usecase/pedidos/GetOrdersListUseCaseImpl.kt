package com.poli.prevendasomie.domain.usecase.pedidos

import androidx.paging.PagingData
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import com.poli.prevendasomie.domain.repository.OrdersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOrdersListUseCaseImpl
@Inject constructor(private val repository: OrdersRepository) : GetOrdersListUseCase {

    override fun invoke(): Flow<PagingData<PedidoVendaProduto>> {

        return repository.getOrderList()
    }
}
