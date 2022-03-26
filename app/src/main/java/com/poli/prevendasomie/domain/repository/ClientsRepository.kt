package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ClientesCadastroDto
import com.poli.prevendasomie.data.remote.responses.ListarClientesDto


interface ClientsRepository {

    suspend fun getClientList(request: Request.ListClientsRequest): Resource<ListarClientesDto>

    suspend fun getClientByCode(request: Request.ClientByCodeRequest): Resource<ClientesCadastroDto>

}

