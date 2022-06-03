package com.poli.prevendasomie.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.data.local.entities.pedidos.ObservacoesEntity
import com.poli.prevendasomie.domain.model.pedidos.Observacoes

data class ObservacoesDto(
    @SerializedName("obs_venda")
    val obsVenda: String?
)

fun ObservacoesDto.toObservacoes(): Observacoes {

    return Observacoes(obsVenda = obsVenda)
}
fun ObservacoesDto.toObservacoesEntity(): ObservacoesEntity {

    return ObservacoesEntity(obsVenda = obsVenda)
}
