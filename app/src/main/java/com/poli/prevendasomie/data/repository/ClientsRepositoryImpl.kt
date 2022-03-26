package com.poli.prevendasomie.data.repository

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ClientesCadastroDto
import com.poli.prevendasomie.data.remote.responses.ListarClientesDto
import com.poli.prevendasomie.domain.repository.ClientsRepository
import javax.inject.Inject


class ClientsRepositoryImpl
    @Inject constructor(private val api: OmieAPI): ClientsRepository {

    override suspend fun getClientList(request: Request.ListClientsRequest): Resource<ListarClientesDto> {

        val response = try {
            api.getClientList(request)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred:\n $e")
        }
        return Resource.Success(response)
    }


    override suspend fun getClientByCode(request: Request.ClientByCodeRequest): Resource<ClientesCadastroDto> {

        val response = try {
            api.getClientByCode(request)
        }catch(e: Exception) {
            return Resource.Error("An unknown error occurred:\n $e")
        }
        return Resource.Success(response)

    }

}