package com.poli.easysales.data.remote.dto.clientes

import com.google.gson.annotations.SerializedName

data class CaracteristicaDto(
    @SerializedName("campo")
    val campo: String? = "",
    @SerializedName("conteudo")
    val conteudo: String? = ""
)
