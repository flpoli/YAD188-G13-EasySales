package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.BuildConfig.APP_KEY
import com.poli.prevendasomie.BuildConfig.APP_SECRET


sealed class Request{

    data class ListClientsRequest(
        val call: String,
        val app_key: String = APP_KEY,
        val app_secret: String = APP_SECRET,
        val param: List<Param.ParamListarClientes>
    )

    data class ClientByCodeRequest (
        val call: String,
        val app_key: String = APP_KEY,
        val app_secret: String = APP_SECRET,
        val param: List<Param.ParamConsultarCliente>
            )
}


