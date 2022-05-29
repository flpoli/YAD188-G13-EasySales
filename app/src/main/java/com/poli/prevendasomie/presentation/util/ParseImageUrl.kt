package com.poli.prevendasomie.presentation.util


fun parseImageUrl(url: String): String{

    return url.replaceAfter('?', "")

}