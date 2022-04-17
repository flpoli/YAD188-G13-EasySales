package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.common.Constants.APPKEY
import com.poli.prevendasomie.common.Constants.APPSECRET
import com.poli.prevendasomie.domain.model.ClientesCadastro
import kotlin.String

sealed class Request {

    data class ListClientsRequest(
        val call: String,
        val appKey: String = APPKEY,
        val appSecret: String = APPSECRET,
        val param: List<Param.ParamListarClientes>
    )

    data class ClientByCodeRequest(
        val call: String = "ConsultarCliente",
        val appKey: String = APPKEY,
        val appSecret: String = APPSECRET,
        val param: List<Param.ParamConsultarCliente>
    )

    data class IncluirClienteRequest(
        val call: String = "IncluirCliente",
        val appKey: String = APPKEY,
        val appSecret: String = APPSECRET,
        val param: List<ClientesCadastro>
    )
}
