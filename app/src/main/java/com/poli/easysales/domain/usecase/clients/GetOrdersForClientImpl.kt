package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.repository.ClientsRepository
import javax.inject.Inject

class GetOrdersForClientImpl @Inject constructor(private val repository: ClientsRepository) : GetOrdersForClient {
    override suspend fun invoke(codigoCliente: Long): List<PedidoVendaProduto> {
        return repository.getOrdersForClient(codigoCliente)
    }
}
