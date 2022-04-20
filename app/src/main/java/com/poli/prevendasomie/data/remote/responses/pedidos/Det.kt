package com.poli.prevendasomie.data.remote.responses.pedidos

import com.google.gson.annotations.SerializedName

data class Det(
    @SerializedName("combustivel")
    val combustivel: Combustivel?,
    @SerializedName("ide")
    val ide: Ide?,
    @SerializedName("imposto")
    val imposto: Imposto?,
    @SerializedName("inf_adic")
    val infAdic: InfAdic?,
    @SerializedName("observacao")
    val observacao: Observacao?,
    @SerializedName("produto")
    val produto: Produto?,
    @SerializedName("rastreabilidade")
    val rastreabilidade: Rastreabilidade?
)
