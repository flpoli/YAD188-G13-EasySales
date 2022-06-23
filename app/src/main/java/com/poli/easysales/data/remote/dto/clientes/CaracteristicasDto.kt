package com.poli.easysales.data.remote.dto.clientes

import com.google.gson.annotations.SerializedName

data class CaracteristicasDto(
    @SerializedName("caracteristicas")
    val caracteristicas: List<CaracteristicaDto>?,
    @SerializedName("codigo_cliente_integracao")
    val codigoClienteIntegracao: String?,
    @SerializedName("codigo_cliente_omie")
    val codigoClienteOmie: Long?
)
