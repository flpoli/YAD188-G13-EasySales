package com.poli.prevendasomie.domain.usecase.clients

import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ReqResponse
import com.poli.prevendasomie.domain.mappers.toClientDto
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.ClientsRepository
import javax.inject.Inject

class IncluirClienteUseCaseImpl
@Inject constructor(private val repository: ClientsRepository) : IncluirClienteUseCase {

    override suspend operator fun invoke(clienteCadastro: ClientesCadastro): ReqResponse {

        val request = Request.IncluirClienteRequest(
            param = listOf(clienteCadastro.toClientDto())
        )

        return repository.addNewClient(request)
    }
}
