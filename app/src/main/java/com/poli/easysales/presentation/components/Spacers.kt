package com.poli.easysales.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val defaultSpacing = 5.dp

@Composable
fun VerticalSpacer(spacing: Dp = defaultSpacing) {
    Spacer(Modifier.padding(0.dp, spacing))
}

@Composable
fun HorizontalSpacer(spacing: Dp = defaultSpacing) {
    Spacer(Modifier.padding(spacing, 0.dp))
}

@Composable
fun EndOfScreen(spacing: Dp = 35.dp) {
    VerticalSpacer(spacing)
}
