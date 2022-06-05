package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.data.remote.dto.ReqResponse
import com.poli.easysales.domain.model.clientes.ClientesCadastro

interface IncluirClienteUseCase {

    suspend operator fun invoke(clienteCadastro: ClientesCadastro): ReqResponse?
}
