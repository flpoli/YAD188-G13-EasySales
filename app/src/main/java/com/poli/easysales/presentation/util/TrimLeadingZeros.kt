package com.poli.easysales.presentation.util

fun trimLeadingZeros(string: String?): String {

    return string?.trimStart('0') ?: ""
}
