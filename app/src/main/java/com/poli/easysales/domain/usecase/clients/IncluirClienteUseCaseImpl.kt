package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.data.remote.Request
import com.poli.easysales.data.remote.dto.ReqResponse
import com.poli.easysales.domain.mappers.toClientDto
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.repository.ClientsRepository
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
