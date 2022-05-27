package com.poli.prevendasomie.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.domain.model.pedidos.ListaParcelas

data class ListaParcelasDto(
    @SerializedName("parcela")
    val parcela: List<ParcelaDto>?
)

fun ListaParcelasDto.toListaParcelas(): ListaParcelas {

    return ListaParcelas(
        parcela = parcela?.map { it.toParcela() }

    )
}
