package com.poli.prevendasomie.domain.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {

    suspend fun getOrderList(): Flow<PagingData<PedidoVendaProduto>>?
}
