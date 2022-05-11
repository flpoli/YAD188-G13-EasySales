package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.common.Constants.CLIENTS_ENDPOINT
import com.poli.prevendasomie.common.Constants.ORDERS_ENDPOINT
import com.poli.prevendasomie.common.Constants.PRODUCTS_ENDPOINT
import com.poli.prevendasomie.data.remote.responses.ReqResponse
import com.poli.prevendasomie.data.remote.responses.clientes.ClientesCadastroDto
import com.poli.prevendasomie.data.remote.responses.clientes.ListarClientesDto
import com.poli.prevendasomie.data.remote.responses.pedidos.ListarPedidosDto
import com.poli.prevendasomie.data.remote.responses.produtos.ListarProdutosDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OmieAPI {

    @Headers("Content-Type:application/json")
    @POST(CLIENTS_ENDPOINT)
    suspend fun getClientList(@Body requestBody: Request.ListClientsRequest): ListarClientesDto

    @Headers("Content-Type:application/json")
    @POST(CLIENTS_ENDPOINT)
    suspend fun getClientByCode(@Body requestBody: Request.ClientByCodeRequest): ClientesCadastroDto

    @Headers("Content-Type:application/json")
    @POST(CLIENTS_ENDPOINT)
    suspend fun addNewClient(@Body requestBody: Request.IncluirClienteRequest): ReqResponse

    @Headers("Content-Type:application/json")
    @POST(PRODUCTS_ENDPOINT)
    suspend fun getProductList(@Body requestBody: Request.ListarProdutosRequest): ListarProdutosDto

    @Headers("Content-Type:application/json")
    @POST(ORDERS_ENDPOINT)
    suspend fun getOrderList(@Body requestBody: Request.ListarPedidosRequest): ListarPedidosDto
}
