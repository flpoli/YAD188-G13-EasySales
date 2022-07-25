package com.poli.easysales.data.local.entities.pedidos

import androidx.room.Embedded
import com.poli.easysales.data.remote.dto.pedidos.Ide

data class DetEntity(


    @Embedded val ide: Ide?,
    @Embedded val imposto: Imposto?,
    @Embedded val infAdic: InfAdic?,
    @Embedded val observacao: Observacao?,
    @Embedded val produto: Produto?,

    )
