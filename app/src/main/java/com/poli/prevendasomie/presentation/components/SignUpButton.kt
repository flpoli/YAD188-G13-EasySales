package com.poli.prevendasomie.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.poli.prevendasomie.R

@Composable
fun SignUpButton(
    onClick: () -> Unit,
    enabled: Boolean,
) {
    PrimaryButton(
        text = stringResource(R.string.sign_up),
        onClick = onClick,
        enabled = enabled,
    )
}