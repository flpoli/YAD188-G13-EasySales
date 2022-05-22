package com.poli.prevendasomie.domain.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {

    fun getOrderList(): Flow<PagingData<PedidoVendaProduto>>
    suspend fun insertSelectedClient(selectedClient: ClientesCadastro)
}
