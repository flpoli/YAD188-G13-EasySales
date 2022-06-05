package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.domain.mappers.toClientModel
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.repository.ClientsRepository
import javax.inject.Inject

class GetClienteDetailUseCaseImpl
@Inject constructor(private val repository: ClientsRepository) : GetClientDetailsUseCase {

    override suspend fun invoke(clientId: Long): ClientesCadastro {

        return repository.getSelectedClient(clientId = clientId).toClientModel()
    }
}
