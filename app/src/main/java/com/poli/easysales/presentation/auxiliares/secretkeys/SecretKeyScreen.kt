package com.poli.easysales.presentation.auxiliares.secretkeys

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.poli.easysales.presentation.components.AppTextField
import com.poli.prevendasomie.R

@Composable
fun SecretKeyScreen(){


        Column(){

            Text(
                text = stringResource(id = R.string.desc_screen_keys,)
            )

            AppTextField(
                text = "",
                onTextChanged = {} ,
                labelText = "APP KEY"
            )

            AppTextField(
                text = "",
                onTextChanged = {} ,
                labelText = "APP SECRET"
            )
        }

}

@Composable
@Preview(showBackground = true)
fun PreviewSecretKeyScreen() {

    SecretKeyScreen()

}