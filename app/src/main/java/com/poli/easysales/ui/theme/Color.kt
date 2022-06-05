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
val TextWhite = Color(0xffeeeeee)
val DeepBlue = Color(0xff06164c)
val ButtonBlue = Color(0xff505cf3)
val DarkerButtonBlue = Color(0xff566894)
val LightRed = Color(0xfffc879a)
val AquaBlue = Color(0xff9aa5c4)
val OrangeYellow1 = Color(0xfff0bd28)
val OrangeYellow2 = Color(0xfff1c746)
val OrangeYellow3 = Color(0xfff4cf65)
val Beige1 = Color(0xfffdbda1)
val Beige2 = Color(0xfffcaf90)
val Beige3 = Color(0xfff9a27b)
val LightGreen1 = Color(0xff54e1b6)
val LightGreen2 = Color(0xff36ddab)
val LightGreen3 = Color(0xff11d79b)
val BlueViolet1 = Color(0xffaeb4fd)
val BlueViolet2 = Color(0xff9fa5fe)
val BlueViolet3 = Color(0xff8f98fd)

val PrimaryColor = Color(0xffba68c8)
val PrimaryLightColor = Color(0xffee98fb)
val PrimaryDarkColor = Color(0xff883997)
val SecondaryColor = Color(0xffe1bee7)
val SecondaryLightColor = Color(0xfffff1ff)
val PrimaryTextColor = Color(0xFF000000)
val SecondaryTextColor = Color(0xFF000000)

val Colors.activeIndicatorColor
    @Composable
    get() = if (isLight) Purple500 else Purple700
val Colors.inactiveIndicatorColor
    @Composable
    get() = if (isLight) LightGrey else DarkGrey