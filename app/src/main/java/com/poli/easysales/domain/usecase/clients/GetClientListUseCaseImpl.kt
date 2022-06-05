package com.poli.easysales.domain.usecase.clients

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.domain.repository.ClientsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetClientListUseCaseImpl
@Inject constructor(private val repository: ClientsRepository) : GetClientListUseCase {

    override operator fun invoke(): Flow<PagingData<ClientesCadastroEntity>> {

        return repository.getClientList()
    }
}
