package com.poli.prevendasomie.domain.usecase.clients

import androidx.paging.PagingData
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.ClientsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetClientListUseCaseImpl
@Inject constructor(private val repository: ClientsRepository) : GetClientListUseCase {

    override operator fun invoke(): Flow<PagingData<ClientesCadastro>>? {

        return repository.getClientList()
    }
}
