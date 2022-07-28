package com.poli.easysales.data.remote.dto


import com.google.gson.annotations.SerializedName

data class CepResponse(
    @SerializedName("bairro")
    val bairro: String?,
    @SerializedName("cep")
    val cep: String?,
    @SerializedName("complemento")
    val complemento: String?,
    @SerializedName("ddd")
    val ddd: String?,
    @SerializedName("gia")
    val gia: String?,
    @SerializedName("ibge")
    val ibge: String?,
    @SerializedName("localidade")
    val localidade: String?,
    @SerializedName("logradouro")
    val logradouro: String?,
    @SerializedName("siafi")
    val siafi: String?,
    @SerializedName("uf")
    val uf: String?
)