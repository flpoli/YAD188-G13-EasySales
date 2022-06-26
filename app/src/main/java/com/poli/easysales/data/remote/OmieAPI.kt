package com.poli.easysales.data.remote

import com.poli.easysales.common.Constants.CARAC_CLIENTS_ENDPOINT
import com.poli.easysales.common.Constants.CLIENTS_ENDPOINT
import com.poli.easysales.common.Constants.CLIENTS_TAG_ENDPOINT
import com.poli.easysales.common.Constants.ESTOQUE_ENDPOINT
import com.poli.easysales.common.Constants.ORDERS_ENDPOINT
import com.poli.easysales.common.Constants.PRODUCTS_ENDPOINT
import com.poli.easysales.data.remote.dto.ReqResponse
import com.poli.easysales.data.remote.dto.clientes.CaracteristicasDto
import com.poli.easysales.data.remote.dto.clientes.ClientesCadastroDto
import com.poli.easysales.data.remote.dto.clientes.ListarClientesDto
import com.poli.easysales.data.remote.dto.pedidos.ListarPedidosDto
import com.poli.easysales.data.remote.dto.produtos.ListarProdutosDto
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
    @POST(CARAC_CLIENTS_ENDPOINT)
    suspend fun getClientCarac(@Body request: Request.CaracteristicasCliente): CaracteristicasDto

    @Headers("Content-Type:application/json")
    @POST(CLIENTS_ENDPOINT)
    suspend fun addNewClient(@Body requestBody: Request.IncluirClienteRequest): ReqResponse

    @Headers("Content-Type:application/json")
    @POST(CLIENTS_ENDPOINT)
    suspend fun deleteClient(@Body requestBody: Request.ExcluirCliente)

    @Headers("Content-Type:application/json")
    @POST(CLIENTS_TAG_ENDPOINT)
    suspend fun addTagCli()

    @Headers("Content-Type:application/json")
    @POST(CLIENTS_TAG_ENDPOINT)
    suspend fun deleteAllTagsCli()

    @Headers("Content-Type:application/json")
    @POST(CLIENTS_TAG_ENDPOINT)
    suspend fun deleteTagByName()


    @Headers("Content-Type:application/json")
    @POST(PRODUCTS_ENDPOINT)
    suspend fun getProductList(@Body requestBody: Request.ListarProdutosRequest): ListarProdutosDto

    @Headers("Content-Type:application/json")
    @POST(ORDERS_ENDPOINT)
    suspend fun getOrderList(@Body requestBody: Request.ListarPedidosRequest): ListarPedidosDto

    @Headers("Content-Type:application/json")
    @POST(ESTOQUE_ENDPOINT)
    suspend fun getStockList(@Body requestBody: Request.ListarPosicaoEstoque)
}
