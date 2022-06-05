package com.poli.easysales.domain.usecase.clients

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import kotlinx.coroutines.flow.Flow

interface GetClientListUseCase {

    operator fun invoke(): Flow<PagingData<ClientesCadastroEntity>>
}
