package com.poli.easysales.presentation.util

fun parseImageUrl(url: String): String {

    return url.replaceAfter('?', "")
}
