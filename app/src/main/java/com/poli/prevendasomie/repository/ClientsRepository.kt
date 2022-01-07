package com.poli.prevendasomie.repository

import com.poli.prevendasomie.common.Env.APP_KEY
import com.poli.prevendasomie.common.Env.APP_SECRET
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ClientList
import javax.inject.Inject

class ClientsRepository @Inject constructor(

    private val api: OmieAPI

){

    suspend fun getClientList(): Resource<ClientList> {


        val response = try{

            val call = "ListarClientes"
            val x = Request(
                call,
                APP_KEY,
                APP_SECRET,
                Param(
                    "N",
                    1,
                    10
                )
            )

            api.getClientList(x)

        }catch(e: Exception){
            return Resource.Error("An unknown error occurred:\n $e")
        }

        return Resource.Success(response)

    }



}