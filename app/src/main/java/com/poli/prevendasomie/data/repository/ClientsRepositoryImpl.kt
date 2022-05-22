package com.poli.prevendasomie.data.repository

import androidx.paging.PagingData
import com.poli.prevendasomie.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ReqResponse
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.repository.ClientsRepository
import com.poli.prevendasomie.domain.repository.LocalDataSource
import com.poli.prevendasomie.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClientsRepositoryImpl
@Inject constructor(
    private val api: OmieAPI,
    private val remote: RemoteDataSource,
    private val local: LocalDataSource
) : ClientsRepository {

    override fun getClientList(): Flow<PagingData<ClientesCadastroEntity>> {

        return remote.getAllClients()
    }

    override fun getNonPaginatedClientList(): Flow<List<ClientesCadastroEntity>> {
        return local.getNonPaginatedClients()
    }

    override suspend fun getSelectedClient(clientId: Long): ClientesCadastroEntity {

        return local.getSelectedClient(clientId = clientId)
    }

    override suspend fun addNewClient(request: Request.IncluirClienteRequest): ReqResponse {

        return api.addNewClient(request)
    }
}
