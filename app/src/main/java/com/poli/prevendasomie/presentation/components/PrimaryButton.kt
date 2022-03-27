package com.poli.prevendasomie.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.poli.prevendasomie.ui.theme.ButtonShape

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        shape = ButtonShape,
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth(),
        enabled = enabled
    ) {
        Text(
            text = text.toUpperCase(Locale.current),
        )
    }
}
