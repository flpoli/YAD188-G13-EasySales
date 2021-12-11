package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.data.remote.DTO.ClientesCadastro
import com.poli.prevendasomie.data.remote.DTO.GetClients
import com.poli.prevendasomie.data.remote.DTO.GetClientsParam
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*

class OmieApiImpl(private val client: HttpClient): OmieAPI {


    override suspend fun getClientList(call: GetClients, param: GetClientsParam): List<ClientesCadastro> {
        return try {
            client.post {
                url(HttpRoutes.CLIENTS)
                contentType(ContentType.Application.Json)
                body = MultiPartFormDataContent(formData {
                    append("t", "I")
                    append(param)

                // acho que não:
                // https://stackoverflow.com/questions/66954521/ktor-client-how-to-specify-body-parameters
                })

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