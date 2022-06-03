package com.poli.prevendasomie.data.remote.dto.estoque

import com.google.gson.annotations.SerializedName

data class Produto(
    @SerializedName("cCodInt")
    val cCodInt: String?,
    @SerializedName("cCodigo")
    val cCodigo: String?,
    @SerializedName("cDescricao")
    val cDescricao: String?,
    @SerializedName("codigo_local_estoque")
    val codigoLocalEstoque: Int?,
    @SerializedName("estoque_minimo")
    val estoqueMinimo: Int?,
    @SerializedName("fisico")
    val fisico: Double?,
    @SerializedName("nCMC")
    val nCMC: Double?,
    @SerializedName("nCodProd")
    val nCodProd: Int?,
    @SerializedName("nPendente")
    val nPendente: Int?,
    @SerializedName("nPrecoUnitario")
    val nPrecoUnitario: Double?,
    @SerializedName("nSaldo")
    val nSaldo: Double?,
    @SerializedName("reservado")
    val reservado: Int?
)
