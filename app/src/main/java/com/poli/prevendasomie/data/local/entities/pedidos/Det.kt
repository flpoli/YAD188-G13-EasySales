package com.poli.prevendasomie.data.local.entities.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.data.remote.dto.pedidos.Ide

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
