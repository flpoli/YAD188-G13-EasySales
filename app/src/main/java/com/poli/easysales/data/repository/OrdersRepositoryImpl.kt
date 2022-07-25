package com.poli.easysales.data.repository

import androidx.paging.PagingData
import com.poli.easysales.data.remote.OmieAPI
import com.poli.easysales.data.remote.Request
import com.poli.easysales.domain.mappers.toClientEntity
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.repository.LocalDataSource
import com.poli.easysales.domain.repository.OrdersRepository
import com.poli.easysales.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrdersRepositoryImpl
@Inject constructor(
    private val api: OmieAPI,
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
) : OrdersRepository {

    override fun getOrderList(): Flow<PagingData<PedidoVendaProduto>> {

        return remote.getAllOrders()
    }

    override suspend fun getOrderById(orderId: Long): PedidoVendaProduto {

        return local.getOrderById(orderId = orderId)
    }

    override suspend fun insertSelectedClient(selectedClient: ClientesCadastro) {
    }


    override suspend fun insertNewOrder(request: Request.IncluirPedidosRequest) {
        api.addNewOrder(request)
    }

    override suspend fun addClientOnOrder(orderId: Int, codigoCliente: Long) {
        local.insertSelectedCliente(orderId, codigoCliente)
    }


}
