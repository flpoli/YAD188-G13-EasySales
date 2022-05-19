package com.poli.prevendasomie.data.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import com.poli.prevendasomie.domain.repository.LocalDataSource
import com.poli.prevendasomie.domain.repository.OrdersRepository
import com.poli.prevendasomie.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrdersRepositoryImpl
@Inject constructor(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
) : OrdersRepository {

    override fun getOrderList(): Flow<PagingData<PedidoVendaProduto>> {

        return remote.getAllOrders()
    }

    override suspend fun insertSelectedClient(selectedClient: ClientesCadastro) {
        local.insertSelectedCliente(selectedClient)
    }
}
