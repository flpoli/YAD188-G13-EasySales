package com.poli.prevendasomie.domain.usecase.clients

import com.poli.prevendasomie.data.remote.dto.ReqResponse
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro

interface IncluirClienteUseCase {

    suspend operator fun invoke(clienteCadastro: ClientesCadastro): ReqResponse?
}
