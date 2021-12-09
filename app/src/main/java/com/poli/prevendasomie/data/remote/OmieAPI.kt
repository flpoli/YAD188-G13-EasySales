package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.data.remote.DTO.ClientesCadastro
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json


interface OmieAPI {

    suspend fun getClientList(): List<ClientesCadastro>
    suspend fun getClient(): ClientesCadastro

}



//POST("https://app.omie.com.br/api/v1/geral/clientes/")
//        val client = HttpClient(Android) {
//            install(JsonFeature) {
//                serializer = KotlinxSerializer(kotlinx.serialization.json.Json{
//                    prettyPrint = true
//                }
//                )
//            }
//        }




