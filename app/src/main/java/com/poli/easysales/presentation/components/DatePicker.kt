package com.poli.easysales.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DatePicker(
    modifier: Modifier,
    isEnabled: Boolean,
    value: String,
    label: String,
    placeHolder: String,
    onValueChange: (String) -> Unit
) {

    AppTextField(
        modifier = modifier,
        text = value,
        placeholderText = placeHolder,
        labelText = label,
        onTextChanged = onValueChange,
        enabled = isEnabled
    )
}
