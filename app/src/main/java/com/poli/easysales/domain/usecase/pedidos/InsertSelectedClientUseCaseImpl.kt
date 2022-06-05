package com.poli.easysales.domain.usecase.pedidos

import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.repository.OrdersRepository
import javax.inject.Inject

class InsertSelectedClientUseCaseImpl
@Inject constructor(private val repository: OrdersRepository) : InsertSelectedClientUseCase {
    override suspend operator fun invoke(selectedClient: ClientesCadastro) {

        repository.insertSelectedClient(

            ClientesCadastro(
                nomeFantasia = selectedClient.nomeFantasia,
                razaoSocial = selectedClient.razaoSocial,
                bairro = selectedClient.bairro

            )
        )
    }
}
