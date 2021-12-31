package com.poli.prevendasomie.data.remote.DTO

import com.poli.prevendasomie.domain.model.Client
import kotlinx.serialization.Serializable

@Serializable
data class GetClientsCall(
    val call: String,
    val APP_KEY: String,
    val APP_SECRET: String,
    val param: GetClientsParam


)

@Serializable
data class GetClientsParam(
    val apenas_importado_api: String,
    val pagina: Int,
    val registros_por_pagina: Int
)

data class ClientsDto (
    val codigo_cliente_integracao: String,
    val nome_fantasia: String
        )

fun ClientsDto.toClients(): Client {

    return Client(
        codigo_cliente_integracao = codigo_cliente_integracao,
        nome_fantasia = nome_fantasia

    )
}