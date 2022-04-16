package com.poli.prevendasomie.domain.use_case.clients

import com.poli.prevendasomie.data.remote.responses.ReqResponse
import com.poli.prevendasomie.domain.model.ClientesCadastro

interface IncluirClienteUseCase {

    suspend operator fun invoke(clienteCadastro: ClientesCadastro): ReqResponse?
}
