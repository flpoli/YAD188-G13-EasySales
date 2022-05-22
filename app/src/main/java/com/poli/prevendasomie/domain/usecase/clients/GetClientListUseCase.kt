package com.poli.prevendasomie.domain.usecase.clients

import androidx.paging.PagingData
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import kotlinx.coroutines.flow.Flow

interface GetClientListUseCase {

    operator fun invoke(): Flow<PagingData<ClientesCadastroEntity>>
}
