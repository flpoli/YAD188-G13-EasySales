package com.poli.prevendasomie.data.remote

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.common.Constants.APP_KEY
import com.poli.prevendasomie.common.Constants.APP_SECRET
import com.poli.prevendasomie.common.Constants.CALL_CONSULTAR_CLIENTE
import com.poli.prevendasomie.common.Constants.CALL_INCLUIR_CLIENTE
import com.poli.prevendasomie.common.Constants.CALL_LISTAR_CLIENTES
import com.poli.prevendasomie.common.Constants.CALL_LISTAR_PEDIDOS
import com.poli.prevendasomie.common.Constants.CALL_LISTAR_POSICAO
import com.poli.prevendasomie.common.Constants.CALL_LISTAR_PRODUTOS
import com.poli.prevendasomie.data.remote.dto.clientes.ClientesCadastroDto
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
}
