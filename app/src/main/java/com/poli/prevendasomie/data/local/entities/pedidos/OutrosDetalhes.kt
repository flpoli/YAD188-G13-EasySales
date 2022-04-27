package com.poli.prevendasomie.data.local.entities.pedidos

import androidx.room.Embedded

data class OutrosDetalhes(
    @Embedded("cBairroOd")
    val cBairroOd: String?,
    @Embedded("cCEPOd")
    val cCEPOd: String?,
    @Embedded("cCidadeOd")
    val cCidadeOd: String?,
    @Embedded("cCnpjCpfOd")
    val cCnpjCpfOd: String?,
    @Embedded("cEnderecoOd")
    val cEnderecoOd: String?,
    @Embedded("cEstadoOd")
    val cEstadoOd: String?,
    @Embedded("cHoraSaidaOd")
    val cHoraSaidaOd: String?,
    @Embedded("cInscrEstadualOd")
    val cInscrEstadualOd: String?,
    @Embedded("cNomeOd")
    val cNomeOd: String?,
    @Embedded("cNumeroOd")
    val cNumeroOd: String?,
    @Embedded("cTelefoneOd")
    val cTelefoneOd: String?,
    @Embedded("dDataSaidaOd")
    val dDataSaidaOd: String?
)
