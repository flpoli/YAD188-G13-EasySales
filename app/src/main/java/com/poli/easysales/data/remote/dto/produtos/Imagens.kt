package com.poli.easysales.data.remote.dto.produtos

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Imagens(
    @SerializedName("url_imagem")
    val urlImagem: String? = ""
) : Parcelable
