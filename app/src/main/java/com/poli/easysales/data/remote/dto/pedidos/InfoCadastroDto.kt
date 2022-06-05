package com.poli.easysales.data.remote.dto.pedidos

import com.google.gson.annotations.SerializedName
import com.poli.easysales.data.local.entities.pedidos.InfoCadastroEntity
import com.poli.easysales.domain.model.pedidos.InfoCadastro

data class InfoCadastroDto(
    @SerializedName("autorizado")
    val autorizado: String?,
    @SerializedName("cImpAPI")
    val cImpAPI: String?,
    @SerializedName("cancelado")
    val cancelado: String?,
    @SerializedName("dAlt")
    val dAlt: String?,
    @SerializedName("dCan")
    val dCan: String?,
    @SerializedName("dFat")
    val dFat: String?,
    @SerializedName("dInc")
    val dInc: String?,
    @SerializedName("denegado")
    val denegado: String?,
    @SerializedName("devolvido")
    val devolvido: String?,
    @SerializedName("devolvido_parcial")
    val devolvidoParcial: String?,
    @SerializedName("faturado")
    val faturado: String?,
    @SerializedName("hAlt")
    val hAlt: String?,
    @SerializedName("hCan")
    val hCan: String?,
    @SerializedName("hFat")
    val hFat: String?,
    @SerializedName("hInc")
    val hInc: String?,
    @SerializedName("uAlt")
    val uAlt: String?,
    @SerializedName("uCan")
    val uCan: String?,
    @SerializedName("uFat")
    val uFat: String?,
    @SerializedName("uInc")
    val uInc: String?
)

fun InfoCadastroDto.toInfoCadastro(): InfoCadastro {

    return InfoCadastro(
        autorizado = autorizado,
        cImpAPI = cImpAPI,
        cancelado = cancelado,
        dAlt = dAlt,
        dCan = dCan,
        dFat = dFat,
        dInc = dInc,
        denegado = denegado,
        devolvido = devolvido,
        devolvidoParcial = devolvidoParcial,
        faturado = faturado,
        hAlt = hAlt,
        hCan = hCan,
        hFat = hFat,
        hInc = hInc,
        uAlt = uAlt,
        uCan = uCan,
        uFat = uFat,
        uInc = uInc
    )
}
fun InfoCadastroDto.toInfoCadastroEntity(): InfoCadastroEntity {

    return InfoCadastroEntity(
        infoCadastroId = 0,
        orderId = 0,
        autorizado = autorizado,
        cImpAPI = cImpAPI,
        cancelado = cancelado,
        dAlt = dAlt,
        dCan = dCan,
        dFat = dFat,
        dInc = dInc,
        denegado = denegado,
        devolvido = devolvido,
        devolvidoParcial = devolvidoParcial,
        faturado = faturado,
        hAlt = hAlt,
        hCan = hCan,
        hFat = hFat,
        hInc = hInc,
        uAlt = uAlt,
        uCan = uCan,
        uFat = uFat,
        uInc = uInc
    )
}
