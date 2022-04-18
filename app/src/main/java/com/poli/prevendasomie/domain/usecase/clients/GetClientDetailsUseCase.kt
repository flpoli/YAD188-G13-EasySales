package com.poli.prevendasomie.domain.usecase.clients

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.domain.model.ClientesCadastro
import kotlinx.coroutines.flow.Flow

interface GetClientDetailsUseCase {

    suspend operator fun invoke(codigoClienteOmie: String): Flow<Resource<ClientesCadastro>>
}
