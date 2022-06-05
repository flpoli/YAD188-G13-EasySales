package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.domain.model.clientes.ClientesCadastro

interface GetClientDetailsUseCase {

    suspend operator fun invoke(clientId: Long): ClientesCadastro
}
