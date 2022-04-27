package com.poli.prevendasomie.data.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ReqResponse
import com.poli.prevendasomie.data.remote.responses.clientes.ClientesCadastroDto
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.ClientsRepository
import com.poli.prevendasomie.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClientsRepositoryImpl
@Inject constructor(
    private val api: OmieAPI,
    private val remote: RemoteDataSource
) : ClientsRepository {

    override fun getClientList(): Flow<PagingData<ClientesCadastro>> {

        return remote.getAllClients()
    }

    override suspend fun getClientByCode(request: Request.ClientByCodeRequest): ClientesCadastroDto {

        return api.getClientByCode(request)
    }

    override suspend fun addNewClient(request: Request.IncluirClienteRequest): ReqResponse {

        return api.addNewClient(request)
    }
}
