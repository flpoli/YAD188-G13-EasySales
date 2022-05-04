package com.poli.prevendasomie.domain.model.pedidos

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName
import com.poli.prevendasomie.data.remote.responses.pedidos.Ide

data class Det(

    @SerializedName("ide")
    @Embedded val ide: Ide?,
    @SerializedName("imposto")
    @Embedded val imposto: Imposto?,
    @SerializedName("inf_adic")
    @Embedded val infAdic: InfAdic?,
    @SerializedName("observacao")
    @Embedded val observacao: Observacao?,
    @SerializedName("produto")
    @Embedded val produto: Produto?,

)
