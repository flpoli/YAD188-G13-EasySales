package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.common.Env
import com.poli.prevendasomie.data.remote.DTO.ClientesCadastro
import com.poli.prevendasomie.data.remote.DTO.ClientsDto
import com.poli.prevendasomie.data.remote.DTO.GetClientsCall
import com.poli.prevendasomie.data.remote.DTO.GetClientsParam
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*


class OmieApiImpl(private val client: HttpClient): OmieAPI {

    override suspend fun getClientList(call: GetClientsCall.Companion): List<ClientsDto> {
        return try {
            client.post {
                url(HttpRoutes.CLIENTS)
                contentType(ContentType.Application.Json)
                body = GetClientsCall(
                    "ListarClientes",
                    Env.APP_KEY, Env.APP_SECRET,
                    GetClientsParam("N", 1, 1))
                }

            }
            catch(e: RedirectResponseException ){
                println("Error: ${e.response.status.description}")
                emptyList()
            }catch(e: ClientRequestException ){
                println("Error: ${e.response.status.description}")
                emptyList()
            }catch(e: ServerResponseException ){
                println("Error: ${e.response.status.description}")
                emptyList()
            }
    }

    override suspend fun getClient(): ClientesCadastro {
        TODO("Not yet implemented")
    }


}

