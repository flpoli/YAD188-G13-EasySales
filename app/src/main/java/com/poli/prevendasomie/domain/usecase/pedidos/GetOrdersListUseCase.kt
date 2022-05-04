package com.poli.prevendasomie.domain.usecase.pedidos

import androidx.paging.PagingData
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import kotlinx.coroutines.flow.Flow

interface GetOrdersListUseCase {

    operator fun invoke(): Flow<PagingData<PedidoVendaProduto>>
}
