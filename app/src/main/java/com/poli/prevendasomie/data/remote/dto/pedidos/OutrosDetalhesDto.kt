package com.poli.prevendasomie.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.domain.model.pedidos.OutrosDetalhes

data class OutrosDetalhesDto(
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

fun OutrosDetalhesDto.toOutrosDetalhes(): OutrosDetalhes {

    return OutrosDetalhes(
        cBairroOd, cCEPOd,
        cCidadeOd = cCidadeOd,
        cCnpjCpfOd = cCnpjCpfOd,
        cEnderecoOd = cEnderecoOd,
        cEstadoOd = cEstadoOd,
        cHoraSaidaOd = cHoraSaidaOd,
        cInscrEstadualOd = cInscrEstadualOd,
        cNomeOd = cNomeOd,
        cNumeroOd = cNumeroOd,
        cTelefoneOd = cTelefoneOd,
        dDataSaidaOd = dDataSaidaOd
    )
}
