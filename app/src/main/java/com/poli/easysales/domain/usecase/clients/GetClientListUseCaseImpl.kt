package com.poli.easysales.domain.usecase.clients

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.domain.repository.ClientsRepository
import com.poli.easysales.domain.repository.Preferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetClientListUseCaseImpl
@Inject constructor(
    private val repository: ClientsRepository,
    private val preferences: Preferences
    ) : GetClientListUseCase {

    override operator fun invoke(): Flow<PagingData<ClientesCadastroEntity>> {

        return if(preferences.readUserSession().appKey.isEmpty()){

            repository.getNonPaginatedClientList().map {
                PagingData.from(it)
            }

        } else {
            repository.getClientList()

        }
    }
}
