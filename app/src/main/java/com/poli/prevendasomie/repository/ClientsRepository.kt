package com.poli.prevendasomie.repository

import com.poli.prevendasomie.common.Env.APP_KEY
import com.poli.prevendasomie.common.Env.APP_SECRET
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ClientList
import com.poli.prevendasomie.data.remote.responses.ClientesCadastro
import javax.inject.Inject

class ClientsRepository @Inject constructor(private val api: OmieAPI) {

    suspend fun getClientList(request: Request): Resource<ClientList> {

        val response = try {
            api.getClientList(request)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred:\n $e")
        }
        return Resource.Success(response)
    }


    suspend fun getClientByCode(request: Request): Resource<ClientesCadastro>{

        val response = try {
            api.getClientByCode(request)
        }catch(e: Exception) {
            return Resource.Error("An unknown error occurred:\n $e")
        }
        return Resource.Success(response)

        }

    }

