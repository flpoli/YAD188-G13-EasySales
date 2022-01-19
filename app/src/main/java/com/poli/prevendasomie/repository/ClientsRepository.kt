package com.poli.prevendasomie.repository

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ListarClientes
import com.poli.prevendasomie.data.remote.responses.ClientesCadastro
import javax.inject.Inject

class ClientsRepository @Inject constructor(private val api: OmieAPI) {

    suspend fun getClientList(request: Request.ListClientsRequest): Resource<ListarClientes> {

        val response = try {
            api.getClientList(request)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred:\n $e")
        }
        return Resource.Success(response)
    }


    suspend fun getClientByCode(request: Request.ClientByCodeRequest): Resource<ClientesCadastro>{

        val response = try {
            api.getClientByCode(request)
        }catch(e: Exception) {
            return Resource.Error("An unknown error occurred:\n $e")
        }
        return Resource.Success(response)

        }

    }

