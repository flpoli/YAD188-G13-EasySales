package com.poli.easysales.data.remote

import com.poli.easysales.data.remote.dto.CepResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CepApi {

    @GET("{cep}/json")
    suspend fun getAddressByCode( @Path("cep") cep: String ): Response<CepResponse>
}