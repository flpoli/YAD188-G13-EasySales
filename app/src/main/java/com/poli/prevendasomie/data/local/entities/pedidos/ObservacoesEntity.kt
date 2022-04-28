package com.poli.prevendasomie.data.local.entities.pedidos

import com.google.gson.annotations.SerializedName

data class ObservacoesEntity(
    @SerializedName("obs_venda")
    val obsVenda: String?
)
