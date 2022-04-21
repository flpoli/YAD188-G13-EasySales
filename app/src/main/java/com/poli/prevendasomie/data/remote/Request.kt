package com.poli.prevendasomie.data.remote

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.common.Constants.APPKEY
import com.poli.prevendasomie.common.Constants.APPSECRET
import com.poli.prevendasomie.domain.model.ClientesCadastro
import kotlin.String

sealed class Request {

    data class ListClientsRequest(
        val call: String,
        @SerializedName("app_key")
        val appKey: String = APPKEY,
        @SerializedName("app_secret")
        val appSecret: String = APPSECRET,
        val param: List<Param.ParamListarClientes>
    )

    data class ClientByCodeRequest(
        val call: String = "ConsultarCliente",
        @SerializedName("app_key")
        val appKey: String = APPKEY,
        @SerializedName("app_secret")
        val appSecret: String = APPSECRET,
        val param: List<Param.ParamConsultarCliente>
    )

    data class IncluirClienteRequest(
        val call: String = "IncluirCliente",
        @SerializedName("app_key")
        val appKey: String = APPKEY,
        @SerializedName("app_secret")
        val appSecret: String = APPSECRET,
        val param: List<ClientesCadastro>
    )

    data class ListarProdutosRequest(
        val call: String = "ListarProdutos",
        @SerializedName("app_key")
        val appKey: String = APPKEY,
        @SerializedName("app_secret")
        val appSecret: String = APPSECRET,
        val param: List<Param.ParamListarProdutos>

    )
    data class ListarPedidosRequest(
        val call: String = "ListarPedidos",
        @SerializedName("app_key")
        val appKey: String = APPKEY,
        @SerializedName("app_secret")
        val appSecret: String = APPSECRET,
        val param: List<Param.ParamListarPedidos>

    )
}
