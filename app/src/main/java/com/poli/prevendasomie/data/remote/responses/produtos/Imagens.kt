package com.poli.prevendasomie.data.remote.responses.produtos

import com.google.gson.annotations.SerializedName

data class Imagens(
    @SerializedName("url_imagem")
    val urlImagem: String? = ""
)
