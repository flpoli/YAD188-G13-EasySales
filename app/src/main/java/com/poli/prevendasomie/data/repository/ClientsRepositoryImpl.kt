package com.poli.prevendasomie.data.repository

import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ReqResponse
import com.poli.prevendasomie.data.remote.responses.clientes.ClientesCadastroDto
import com.poli.prevendasomie.data.remote.responses.clientes.ListarClientesDto
import com.poli.prevendasomie.domain.repository.ClientsRepository
import javax.inject.Inject

class ClientsRepositoryImpl
@Inject constructor(private val api: OmieAPI) : ClientsRepository {

    override suspend fun getClientList(request: Request.ListClientsRequest): ListarClientesDto {

        return api.getClientList(request)
    }

    override suspend fun getClientByCode(request: Request.ClientByCodeRequest): ClientesCadastroDto {

        return api.getClientByCode(request)
    }

    override suspend fun addNewClient(request: Request.IncluirClienteRequest): ReqResponse {

        return api.addNewClient(request)
    }
}
