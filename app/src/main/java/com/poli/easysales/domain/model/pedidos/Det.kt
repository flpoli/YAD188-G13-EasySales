package com.poli.easysales.domain.model.pedidos

import androidx.room.Embedded
import com.poli.easysales.data.remote.dto.pedidos.Ide

data class Det(

    @Embedded val ide: Ide? = Ide(),
    @Embedded val imposto: Imposto? = Imposto(),
    @Embedded val infAdic: InfAdic? = InfAdic(),
    @Embedded val observacao: Observacao? = Observacao(),
    @Embedded val produto: Produto? = Produto(),

)
