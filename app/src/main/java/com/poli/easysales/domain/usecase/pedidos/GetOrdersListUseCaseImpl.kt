package com.poli.easysales.domain.usecase.pedidos

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.pedidos.PedidoVendaProdutoEntity
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.repository.OrdersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOrdersListUseCaseImpl
@Inject constructor(private val repository: OrdersRepository) : GetOrdersListUseCase {

    override fun invoke(): Flow<PagingData<PedidoVendaProdutoEntity>> {
        return repository.getOrderList()

    }
}
