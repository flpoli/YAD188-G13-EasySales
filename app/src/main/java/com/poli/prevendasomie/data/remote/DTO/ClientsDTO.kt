package com.poli.prevendasomie.data.remote.DTO

import kotlinx.serialization.Serializable

@Serializable
data class GetClients(
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