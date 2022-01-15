package com.poli.prevendasomie.data.remote


sealed class Request{

    data class ListClientsRequest(
        val call: String,
        val app_key: String,
        val app_secret: String,
        val param: List<Param.ParamListarClientes>
    )

    data class ClientByCodeRequest (
        val call: String,
        val app_key: String,
        val app_secret: String,
        val param: List<Param.ParamConsultarCliente>
            )
}


