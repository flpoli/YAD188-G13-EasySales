package com.poli.prevendasomie.data.models

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.data.remote.responses.*
import java.io.Serializable

data class ClientesCadastroEntry (

    @SerializedName("nome_fantasia")
    val nomeFantasia: String,
//    @SerializedName("razao_social")
//    val razaoSocial: String,
//    @SerializedName("cnpj_cpf")
//    val cnpjCpf: String

)