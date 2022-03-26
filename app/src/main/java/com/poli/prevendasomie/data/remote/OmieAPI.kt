package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.data.remote.responses.ListarClientesDto
import com.poli.prevendasomie.data.remote.responses.ClientesCadastroDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST




interface OmieAPI {

    @Headers("Content-Type:application/json")
    @POST("geral/clientes/")
    suspend fun getClientList(@Body requestBody: Request.ListClientsRequest): ListarClientesDto

    @Headers("Content-Type:application/json")
    @POST("geral/clientes/")
    suspend fun getClientByCode(@Body requestBody: Request.ClientByCodeRequest): ClientesCadastroDto

}
