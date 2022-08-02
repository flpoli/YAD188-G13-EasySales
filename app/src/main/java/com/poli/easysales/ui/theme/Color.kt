package com.poli.easysales.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val LightGrey = Color(0xFFD8D8D8)
val DarkGrey = Color(0xFF2A2A2A)


val PrimaryColor = Color(0xff1565c0)
val PrimaryLightColor = Color(0xff5e92f3)
val PrimaryDarkColor = Color(0xff003c8f)
val SecondaryColor = Color(0xff90caf9)
val SecondaryLightColor = Color(0xffc3fdff)
val secondaryDarkColor = Color(0xff5d99c6)
val PrimaryTextColor = Color(0xffffffff)
val SecondaryTextColor = Color(0xFF000000)

val Colors.activeIndicatorColor
    @Composable
    get() = if (isLight) Purple500 else Purple700
val Colors.inactiveIndicatorColor
    @Composable
    get() = if (isLight) LightGrey else DarkGrey
