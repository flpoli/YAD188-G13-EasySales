package com.poli.prevendasomie.domain.usecase.clients

import com.poli.prevendasomie.data.remote.responses.ReqResponse
import com.poli.prevendasomie.domain.model.ClientesCadastro

interface IncluirClienteUseCase {

    suspend operator fun invoke(clienteCadastro: ClientesCadastro): ReqResponse?
}
