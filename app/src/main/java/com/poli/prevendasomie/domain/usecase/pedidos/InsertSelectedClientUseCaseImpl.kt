package com.poli.prevendasomie.domain.usecase.pedidos

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.OrdersRepository
import javax.inject.Inject

class InsertSelectedClientUseCaseImpl
@Inject constructor(private val repository: OrdersRepository) : InsertSelectedClientUseCase {
    override suspend fun invoke(selectedClient: ClientesCadastro) {

        repository.insertSelectedClient(selectedClient)
    }
}
