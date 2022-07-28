package com.poli.easysales.data.local.entities.pedidos

import androidx.room.Embedded
import com.poli.easysales.data.remote.dto.pedidos.Ide

data class DetEntity(

    @Embedded val ide: Ide?,
    @Embedded val imposto: ImpostoEntity?,
    @Embedded val infAdic: InfAdicEntity?,
    @Embedded val observacao: ObservacaoEntity?,
    @Embedded val produto: ProdutoEntity?,

)
