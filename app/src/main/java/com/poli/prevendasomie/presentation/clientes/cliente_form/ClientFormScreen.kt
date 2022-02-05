package com.poli.prevendasomie.presentation.clientes.cliente_form

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.poli.prevendasomie.presentation.login.AppTextField

@Composable
fun ClientFormScreen(){

}


@Composable
fun InputColumn(
    viewState: ClienteFormState,


    ){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        RazaoSocialInput(
            text = "test",
            onTextChanged = { println("razao") },
            errorMessage = null,
            enabled = true
        )
        Spacer(modifier = Modifier.height(12.dp))
        //NomeFantasiaInput()
        Spacer(modifier = Modifier.height(12.dp))


    }
}

@Composable
fun RazaoSocialInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean?
){
    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Razão social",
        enabled = enabled!!
    )
}
@Composable
fun NomeFantasiaInput(
    text: String,
    onTextChanged: (String) -> Unit,
    //errorMessage: String?,
    enabled: Boolean
){
    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        //errorMessage = errorMessage,
        labelText = "Nome fantasia",
        //enabled = enabled
    )
}