package com.poli.easysales.data.remote

import com.google.gson.annotations.SerializedName
import com.poli.easysales.common.Constants.CALL_CARACTERISTICAS_CLIENTE
import com.poli.easysales.common.Constants.CALL_CONSULTAR_CLIENTE
import com.poli.easysales.common.Constants.CALL_EXCLUIR_CLIENTE
import com.poli.easysales.common.Constants.CALL_INCLUIR_CLIENTE
import com.poli.easysales.common.Constants.CALL_LISTAR_CLIENTES
import com.poli.easysales.common.Constants.CALL_LISTAR_PEDIDOS
import com.poli.easysales.common.Constants.CALL_LISTAR_POSICAO
import com.poli.easysales.common.Constants.CALL_LISTAR_PRODUTOS
import com.poli.easysales.data.remote.dto.clientes.ClientesCadastroDto
import kotlin.String

sealed class Request {

    data class ListClientsRequest(
        val call: String = CALL_LISTAR_CLIENTES,
        @SerializedName("app_key")
        val appKey: String = APP_KEY,
        @SerializedName("app_secret")
        val appSecret: String = APP_SECRET,
        val param: List<Param.ParamListarClientes>
    )

    data class ClientByCodeRequest(
        val call: String = CALL_CONSULTAR_CLIENTE,
        @SerializedName("app_key")
        val appKey: String = APP_KEY,
        @SerializedName("app_secret")
        val appSecret: String = APP_SECRET,
        val param: List<Param.ParamConsultarCliente>
    )

    data class IncluirClienteRequest(
        val call: String = CALL_INCLUIR_CLIENTE,
        @SerializedName("app_key")
        val appKey: String = APP_KEY,
        @SerializedName("app_secret")
        val appSecret: String = APP_SECRET,
        val param: List<ClientesCadastroDto>
    )

    data class ListarProdutosRequest(
        val call: String = CALL_LISTAR_PRODUTOS,
        @SerializedName("app_key")
        val appKey: String = APP_KEY,
        @SerializedName("app_secret")
        val appSecret: String = APP_SECRET,
        val param: List<Param.ParamListarProdutos>

    )
    data class ListarPedidosRequest(
        val call: String = CALL_LISTAR_PEDIDOS,
        @SerializedName("app_key")
        val appKey: String = APP_KEY,
        @SerializedName("app_secret")
        val appSecret: String = APP_SECRET,
        val param: List<Param.ParamListarPedidos>

    )

    data class ListarPosicaoEstoque(

        val call: String = CALL_LISTAR_POSICAO,
        @SerializedName("app_key")
        val appKey: String = APP_KEY,
        @SerializedName("app_secret")
        val appSecret: String = APP_SECRET,
        val param: List<Param.ParamListarPosicao>
    )

    data class CaracteristicasCliente(
        val call: String = CALL_CARACTERISTICAS_CLIENTE,
        @SerializedName("app_key")
        val appKey: String = APP_KEY,
        @SerializedName("app_secret")
        val appSecret: String = APP_SECRET,
        val param: List<Param.ParamCaracCliente>
    )

    data class ExcluirCliente(
        val call: String = CALL_EXCLUIR_CLIENTE,
        @SerializedName("app_key")
        val appKey: String = APP_KEY,
        @SerializedName("app_secret")
        val appSecret: String = APP_SECRET,
        val param: List<Param.ParamCaracCliente>
    )

    companion object {

        var APP_KEY: String = ""
        var APP_SECRET: String = ""
    }
}
