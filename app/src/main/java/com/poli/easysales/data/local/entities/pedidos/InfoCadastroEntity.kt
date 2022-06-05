package com.poli.easysales.data.local.entities.pedidos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "info_cadastro_entity")
data class InfoCadastroEntity(

    @PrimaryKey(autoGenerate = true)
    val infoCadastroId: Int,
    val orderId: Int,

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
