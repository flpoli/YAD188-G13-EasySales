package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.BuildConfig.APP_KEY
import com.poli.prevendasomie.BuildConfig.APP_SECRET
import com.poli.prevendasomie.common.Constants.APPKEY
import com.poli.prevendasomie.common.Constants.APPSECRET
import com.poli.prevendasomie.domain.model.ClientesCadastro
import kotlin.String

sealed class Request {

    data class ListClientsRequest(
        val call: String,
        val app_key: String = APPKEY,
        val app_secret: String = APPSECRET,
        val param: List<Param.ParamListarClientes>
    )

    data class ClientByCodeRequest(
        val call: String,
        val app_key: String = APPKEY,
        val app_secret: String = APPSECRET,
        val param: List<Param.ParamConsultarCliente>
    )

    data class IncluirClienteRequest(
        val call: String = "IncluirCliente",
        val app_key: String = APPKEY,
        val app_secret: String = APPSECRET,
        val param: List<ClientesCadastro>
    )
}
