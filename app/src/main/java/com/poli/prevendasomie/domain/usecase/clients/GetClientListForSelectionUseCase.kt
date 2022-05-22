package com.poli.prevendasomie.domain.usecase.clients

import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import kotlinx.coroutines.flow.Flow

interface GetClientListForSelectionUseCase {

    operator fun invoke(): Flow<List<ClientesCadastroEntity>>
}
