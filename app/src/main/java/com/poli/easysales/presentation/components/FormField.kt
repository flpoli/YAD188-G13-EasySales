package com.poli.easysales.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FormField(
    text: String,
    onTextChanged: (String) -> Unit
) {

    Column {

        TextField(

            value = text,
            onValueChange = onTextChanged,
            singleLine = true
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewFormField() {

    FormField(
        text = "test",
        onTextChanged = {}
    )
}
