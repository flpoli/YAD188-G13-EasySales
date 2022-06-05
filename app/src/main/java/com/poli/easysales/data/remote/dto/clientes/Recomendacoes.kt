package com.poli.easysales.data.remote.dto.clientes

import com.google.gson.annotations.SerializedName

data class Recomendacoes(
    @SerializedName("gerar_boletos")
    val gerarBoletos: String = ""
)
