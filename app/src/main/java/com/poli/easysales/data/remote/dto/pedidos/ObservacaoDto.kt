package com.poli.easysales.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.easysales.domain.model.pedidos.Observacao

data class ObservacaoDto(
    @SerializedName("obs_item")
    val obsItem: String?
)
fun ObservacaoDto.toObservacao(): Observacao {

    return Observacao(
        obsItem = obsItem
    )
}
