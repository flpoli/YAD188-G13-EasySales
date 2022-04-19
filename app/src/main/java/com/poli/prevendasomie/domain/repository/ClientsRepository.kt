package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.clientes.ClientesCadastroDto
import com.poli.prevendasomie.data.remote.responses.clientes.ListarClientesDto
import com.poli.prevendasomie.data.remote.responses.ReqResponse

interface ClientsRepository {

    suspend fun getClientList(request: Request.ListClientsRequest): ListarClientesDto
    suspend fun getClientByCode(request: Request.ClientByCodeRequest): ClientesCadastroDto
    suspend fun addNewClient(request: Request.IncluirClienteRequest): ReqResponse
}
