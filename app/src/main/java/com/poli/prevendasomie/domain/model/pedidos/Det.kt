package com.poli.prevendasomie.domain.model.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.data.remote.responses.pedidos.Ide

data class Det(

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

)
