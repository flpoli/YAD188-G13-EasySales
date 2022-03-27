package com.poli.prevendasomie.presentation.clientes.cliente_form

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.prevendasomie.presentation.components.AppTextField
import com.poli.prevendasomie.presentation.components.PrimaryButton

@Composable
fun ClientFormScreen(
    navController: NavHostController,
    viewModel: ClientFormViewModel = hiltViewModel()
){

    val viewState = viewModel.viewState.collectAsState()

    InputColumn(
        viewState = viewState.value,
        onTextChanged = viewModel::onEmailChanged
    )
}


@Composable
fun InputColumn(
    viewState: ClienteFormViewState,
    onTextChanged: (String) -> Unit

    ){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        RazaoSocialInput(
            text = "",
            onTextChanged = { },
            errorMessage = null,
            enabled = true
        )
        Spacer(modifier = Modifier.height(12.dp))

        NomeFantasiaInput(
            text = "",
            onTextChanged = { },
            errorMessage = null,
            enabled = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        CpfCnpjInput(
            text = "",
            onTextChanged = { },
            errorMessage = null,
            enabled = true
        )
        Spacer(modifier = Modifier.height(12.dp))

        EmailInput(
            text = viewState.cliente.email ?: "",
            onTextChanged = onTextChanged,
            errorMessage = null,
            enabled = true
        )
        Spacer(modifier = Modifier.height(12.dp))

        TelefoneInput(
            text = "",
            onTextChanged = { },
            errorMessage = null,
            enabled = true
        )

        Spacer(modifier = Modifier.height(12.dp))


        PrimaryButton(
            onClick = {},
            text = "cadastrar",
        )

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
    errorMessage: String?,
    enabled: Boolean
){
    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Nome fantasia",
        enabled = enabled
    )
}
@Composable
fun CpfCnpjInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean
){
    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "CPF/CNPJ",
        enabled = enabled
    )
}

@Composable
fun EmailInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean
){
    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Email",
        enabled = enabled
    )
}

@Composable
fun TelefoneInput(
    text: String,
    onTextChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean
){

    //esses campos deveriam ficar em uma Row
    // , cada campo com tamanhos diferentes

    AppTextField(
        modifier = Modifier.size(15.dp),
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "ddd",
        enabled = enabled
    )
    AppTextField(
        modifier = Modifier.size(30.dp),

        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Telefone",
        enabled = enabled
    )
}