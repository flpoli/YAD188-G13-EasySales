package com.poli.prevendasomie.domain.usecase.pedidos

import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.domain.mappers.toClientEntity
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.OrdersRepository
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
