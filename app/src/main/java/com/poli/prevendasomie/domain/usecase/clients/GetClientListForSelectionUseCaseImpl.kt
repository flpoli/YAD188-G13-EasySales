package com.poli.prevendasomie.domain.usecase.clients

import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.ClientsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetClientListForSelectionUseCaseImpl
@Inject constructor(private val repository: ClientsRepository) : GetClientListForSelectionUseCase {

    override operator fun invoke(): Flow<List<ClientesCadastroEntity>> {

        return repository.getNonPaginatedClientList()
    }
}
