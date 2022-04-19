package com.poli.prevendasomie.data.remote.responses.clientes

import com.google.gson.annotations.SerializedName

data class DadosBancarios(
    @SerializedName("agencia")
    val agencia: String,
    @SerializedName("codigo_banco")
    val codigoBanco: String,
    @SerializedName("conta_corrente")
    val contaCorrente: String,
    @SerializedName("doc_titular")
    val docTitular: String,
    @SerializedName("nome_titular")
    val nomeTitular: String
)
