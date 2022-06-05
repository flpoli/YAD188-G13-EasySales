package com.poli.easysales.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.poli.easysales.ui.theme.TextFieldShape

@Composable
fun AppTextField(

    text: String,
    onTextChanged: (String) -> Unit,
    labelText: String?,
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    enabled: Boolean = true,
    trailingIcon: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholderText: String? = null,
) {

    val labelComposable: (@Composable () -> Unit)? = labelText?.let {

        @Composable {
            Text(
                text = labelText,
            )
        }
    }

    val placeholderComposable: (@Composable () -> Unit)? = labelText?.let {

        @Composable {
            Text(
                text = labelText,
            )
        }
    }

    Column {

        OutlinedTextField(

            value = text,
            onValueChange = onTextChanged,
            label = labelComposable,
            shape = TextFieldShape,

            modifier = modifier
                .heightIn(48.dp)
                .fillMaxWidth(),
            isError = (errorMessage != null),
            enabled = enabled,
            placeholder = placeholderComposable,
            trailingIcon = trailingIcon,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            singleLine = true
        )

        if (errorMessage != null) {
            Text(
                text = errorMessage,
                modifier = modifier
                    .padding(
                        top = 4.dp,
                        start = 16.dp
                    )
            )
        }
    }
}
