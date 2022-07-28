package com.poli.easysales.domain.usecase.pedidos

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.pedidos.PedidoVendaProdutoEntity
import kotlinx.coroutines.flow.Flow

interface GetOrdersListUseCase {

    operator fun invoke(): Flow<PagingData<PedidoVendaProdutoEntity>>
}
