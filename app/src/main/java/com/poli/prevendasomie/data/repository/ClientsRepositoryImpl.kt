package com.poli.prevendasomie.data.repository

import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ClientesCadastroDto
import com.poli.prevendasomie.data.remote.responses.ListarClientesDto
import com.poli.prevendasomie.domain.repository.ClientsRepository
import javax.inject.Inject

class ClientsRepositoryImpl
@Inject constructor(private val api: OmieAPI) : ClientsRepository {

    override suspend fun getClientList(request: Request.ListClientsRequest): ListarClientesDto {

//        val response = try {
//            api.getClientList(request)
//        } catch (e: Exception) {
//            return Resource.Error("An unknown error occurred:\n $e")
//        }
//        return Resource.Success(response)

        return api.getClientList(request)
    }

    override suspend fun getClientByCode(request: Request.ClientByCodeRequest): ClientesCadastroDto {

//        val response = try {
//            api.getClientByCode(request)
//        }catch(e: Exception) {
//            return Resource.Error("An unknown error occurred:\n $e")
//        }
//        return Resource.Success(response)

        return api.getClientByCode(request)
    }
}
