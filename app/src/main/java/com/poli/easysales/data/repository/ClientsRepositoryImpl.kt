package com.poli.easysales.data.repository

import androidx.paging.PagingData
import com.poli.easysales.data.local.entities.clientes.ClientesCadastroEntity
import com.poli.easysales.data.remote.CepApi
import com.poli.easysales.data.remote.OmieAPI
import com.poli.easysales.data.remote.Param
import com.poli.easysales.data.remote.Request
import com.poli.easysales.data.remote.dto.CepResponse
import com.poli.easysales.data.remote.dto.ReqResponse
import com.poli.easysales.data.remote.dto.clientes.CaracteristicasDto
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.repository.ClientsRepository
import com.poli.easysales.domain.repository.LocalDataSource
import com.poli.easysales.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class ClientsRepositoryImpl
@Inject constructor(
    private val api: OmieAPI,
    private val cepApi: CepApi,
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

    override suspend fun getClientCarac(codigoCliente: Long): CaracteristicasDto {

        val request = Request.CaracteristicasCliente(
            param = listOf(Param.ParamCaracCliente(codigoCliente))
        )

        return api.getClientCarac(request = request)
    }

    override suspend fun deleteClientByCode(codigoCliente: Long) {

    }

    override suspend fun addNewClient(request: Request.IncluirClienteRequest): ReqResponse {

        return api.addNewClient(request)
    }

    override suspend fun getOrdersForClient(codigoCliente: Long): List<PedidoVendaProduto> {

        return local.getOrdersForClient(codigoCliente)
    }

    override suspend fun getAddressByCep(cep: String): Response<CepResponse> {

        return cepApi.getAddressByCode(cep)
    }

    override suspend fun insertNewClient(client: ClientesCadastro) {
        local.insertNewClient(client)
    }
}
