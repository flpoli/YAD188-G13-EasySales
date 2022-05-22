package com.poli.prevendasomie.domain.usecase.clients

import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

interface GetClientDetailsUseCase {

    suspend operator fun invoke(clientId: Long): ClientesCadastro
}
