package com.poli.easysales.data.remote.dto.pedidos

import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class CofinsPadrao(
    @Embedded val aliqCofins: Double?,
    @Embedded val baseCofins: Double?,
    @Embedded val codSitTribCofins: String?,
    @Embedded val qtdeUnidTribCofins: Int?,
    @Embedded val tipoCalculoCofins: String?,
    @Embedded val valorCofins: Double?,
    @Embedded val valorUnidTribCofins: Double?
)
