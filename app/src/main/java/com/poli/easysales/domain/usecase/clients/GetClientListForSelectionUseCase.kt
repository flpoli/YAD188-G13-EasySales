package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import kotlinx.coroutines.flow.Flow

interface GetClientListForSelectionUseCase {

    operator fun invoke(): Flow<List<ClientesCadastroEntity>>
}
