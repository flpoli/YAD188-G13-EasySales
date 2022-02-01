package com.poli.prevendasomie.core

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

sealed class UIText {

    data class StringText(val value: String): UIText()
    data class ResourceText(@StringRes val value: Int): UIText()
}

fun UIText.getString(context: Context): String {

    return when (this) {
        is UIText.StringText -> this.value
        is UIText.ResourceText -> context.getString(this.value)
    }
}

@Composable
fun UIText.getString(): String {
    return this.getString(LocalContext.current)
}