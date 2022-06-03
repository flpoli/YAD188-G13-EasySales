package com.poli.prevendasomie.presentation.util

fun trimLeadingZeros(string: String?): String {

    return string?.trimStart('0') ?: ""
}
