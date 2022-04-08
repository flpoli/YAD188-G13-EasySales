package com.poli.prevendasomie.domain.use_case.clients

import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ReqResponse
import com.poli.prevendasomie.domain.model.ClientesCadastro
import com.poli.prevendasomie.domain.repository.ClientsRepository
import javax.inject.Inject

class IncluirClienteUseCaseImpl
@Inject constructor(private val repository: ClientsRepository) : IncluirClienteUseCase {

    override suspend operator fun invoke(clienteCadastro: ClientesCadastro): ReqResponse {

        val request = Request.IncluirClienteRequest(
            param = listOf(clienteCadastro)
        )

        return repository.addNewClient(request)
    }
}
