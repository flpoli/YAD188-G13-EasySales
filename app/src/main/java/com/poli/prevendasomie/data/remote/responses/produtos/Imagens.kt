package com.poli.prevendasomie.data.remote.responses.produtos


import androidx.room.Embedded
import com.google.gson.annotations.SerializedName

data class Imagens(
    @SerializedName("url_imagem")
    val urlImagem: String? = ""
)