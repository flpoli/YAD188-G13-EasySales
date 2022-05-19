package com.poli.prevendasomie.domain.usecase.clients

import com.poli.prevendasomie.domain.mappers.toClientModel
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.ClientsRepository
import javax.inject.Inject

class GetClienteDetailUseCaseImpl
@Inject constructor(private val repository: ClientsRepository) : GetClientDetailsUseCase {

    override suspend fun invoke(clientId: Int): ClientesCadastro {

        return repository.getSelectedClient(clientId = clientId).toClientModel()
    }
}
