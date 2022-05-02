package com.poli.prevendasomie.data.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import com.poli.prevendasomie.domain.repository.OrdersRepository
import com.poli.prevendasomie.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrdersRepositoryImpl
@Inject constructor(private val remote: RemoteDataSource) : OrdersRepository {

    override fun getOrderList(): Flow<PagingData<PedidoVendaProduto>> {

        return remote.getAllOrders()
    }
}
