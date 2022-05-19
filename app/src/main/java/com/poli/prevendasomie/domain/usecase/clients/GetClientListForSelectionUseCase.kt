package com.poli.prevendasomie.domain.usecase.clients

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import kotlinx.coroutines.flow.Flow

interface GetClientListForSelectionUseCase {

    operator fun invoke(): Flow<List<ClientesCadastro>>
}
