package com.poli.easysales.domain.model.pedidos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.poli.easysales.data.remote.dto.pedidos.Ide

data class Det(

    @PrimaryKey(autoGenerate = true)
    val primarykey: Int? = 0,
    @Embedded val ide: Ide? = Ide(),
    @Embedded val imposto: Imposto? = Imposto(),
    @Embedded val infAdic: InfAdic? = InfAdic(),
    @Embedded val observacao: Observacao? = Observacao(),
    @Embedded val produto: Produto? = Produto(),

    )
