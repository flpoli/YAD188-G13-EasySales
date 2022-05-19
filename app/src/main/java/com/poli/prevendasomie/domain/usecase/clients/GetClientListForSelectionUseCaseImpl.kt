package com.poli.prevendasomie.domain.usecase.clients

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.ClientsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetClientListForSelectionUseCaseImpl @Inject constructor(private val repository: ClientsRepository) : GetClientListForSelectionUseCase {

    override operator fun invoke(): Flow<List<ClientesCadastro>> {

        return repository.getNonPaginatedClientList()
    }
}
