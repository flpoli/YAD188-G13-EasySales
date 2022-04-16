package com.poli.prevendasomie.data.models

import com.google.gson.annotations.SerializedName

data class ClientesCadastroEntry(

    @SerializedName("nome_fantasia")
    val nomeFantasia: String,
//    @SerializedName("razao_social")
//    val razaoSocial: ResponseTokenDto,
//    @SerializedName("cnpj_cpf")
//    val cnpjCpf: ResponseTokenDto

)
