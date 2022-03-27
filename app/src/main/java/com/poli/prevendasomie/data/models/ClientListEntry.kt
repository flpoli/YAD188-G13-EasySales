package com.poli.prevendasomie.data.models

import com.google.gson.annotations.SerializedName

data class ClientListEntry(

    @SerializedName("clientes_cadastro")
    val clientesCadastro: List<ClientesCadastroEntry>

)
