package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.data.remote.DTO.*
import dagger.Provides
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import kotlinx.serialization.json.Json


interface OmieAPI {


    suspend fun getClientList(call: GetClientsCall): List<ClientsDto>
    suspend fun getClient(): ClientesCadastro


    companion object {
        fun create(): OmieAPI {

            return OmieApiImpl(client = HttpClient(Android){
                install(Logging){
                    level = LogLevel.ALL
                }
                install(JsonFeature){
                    serializer = KotlinxSerializer()
                }
            })
        }
    }

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




