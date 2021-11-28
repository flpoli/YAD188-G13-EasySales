package com.poli.prevendasomie.data.remote

import retrofit2.http.POST

interface OmieAPI {

    @POST("https://app.omie.com.br/api/v1/geral/clientes/")
    suspend fun getClients()
}