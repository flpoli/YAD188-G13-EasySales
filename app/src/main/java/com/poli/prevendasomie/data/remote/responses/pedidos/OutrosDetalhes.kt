package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class OutrosDetalhes(
    @SerializedName("cBairroOd")
    val cBairroOd: String?,
    @SerializedName("cCEPOd")
    val cCEPOd: String?,
    @SerializedName("cCidadeOd")
    val cCidadeOd: String?,
    @SerializedName("cCnpjCpfOd")
    val cCnpjCpfOd: String?,
    @SerializedName("cEnderecoOd")
    val cEnderecoOd: String?,
    @SerializedName("cEstadoOd")
    val cEstadoOd: String?,
    @SerializedName("cHoraSaidaOd")
    val cHoraSaidaOd: String?,
    @SerializedName("cInscrEstadualOd")
    val cInscrEstadualOd: String?,
    @SerializedName("cNomeOd")
    val cNomeOd: String?,
    @SerializedName("cNumeroOd")
    val cNumeroOd: String?,
    @SerializedName("cTelefoneOd")
    val cTelefoneOd: String?,
    @SerializedName("dDataSaidaOd")
    val dDataSaidaOd: String?
)
