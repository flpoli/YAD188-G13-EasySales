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

// TODO: ADD companion object que retorna a implementação das funções acima. Aqui deve
// TODO: ser feita a configuração do client, os plugins do ktor etc..
// TODO: Código exemplo abaixo:

//        companion object {
//            fun create(): PostService {
//
//                return PostServiceImpl(client = HttpClient(Android){
//                    install(Logging){
//                        level = LogLevel.ALL
//                    }
//                    install(JsonFeature){
//                        serializer = KotlinxSerializer()
//                    }
//                })
//            }
//        }


// ------------------------

//POST("https://app.omie.com.br/api/v1/geral/clientes/")
//        val client = HttpClient(Android) {
//            install(JsonFeature) {
//                serializer = KotlinxSerializer(kotlinx.serialization.json.Json{
//                    prettyPrint = true
//                }
//                )
//            }
//        }




