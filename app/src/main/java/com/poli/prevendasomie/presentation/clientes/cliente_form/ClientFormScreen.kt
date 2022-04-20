package com.poli.prevendasomie.presentation.clientes.cliente_form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.core.getString
import com.poli.prevendasomie.presentation.components.AppTextField
import com.poli.prevendasomie.presentation.components.PrimaryButton
import kotlinx.coroutines.flow.collect

@Composable
fun ClientFormScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    viewModel: ClientFormViewModel = hiltViewModel()
) {

    // val spacing = LocalSpacing.current

    val context = LocalContext.current
    val viewState = viewModel.viewState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect {
                event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {

                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.getString(context)
                    )
                    //    navController.navigate(Screen.ClientListScreen.route)
                }
            }
        }
    }

    InputColumn(
        viewState = viewState.value,
        onEmailChanged = viewModel::onEmailChanged,
        onRazaoSocalChanged = viewModel::onRazaoSocialChanged,
        onNomeFantasiaChanged = viewModel::onNomeFantasiaChanged,
        onCnpjCpfChanged = viewModel::onCnpjCpfChanged,
        onTelefone1DddChanged = viewModel::onTelefone1DddChanged,
        onTelefone1Numero = viewModel::ontelefone1NumeroChanged,
        onBtnClicked = viewModel::onRegisterClicked

    )
}

@Composable
fun InputColumn(
    viewState: ClienteFormViewState,
    onEmailChanged: (String) -> Unit,
    onRazaoSocalChanged: (String) -> Unit,
    onNomeFantasiaChanged: (String) -> Unit,
    onCnpjCpfChanged: (String) -> Unit,
    onTelefone1DddChanged: (String) -> Unit,
    onTelefone1Numero: (String) -> Unit,
    onBtnClicked: () -> Unit

) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        RazaoSocialInput(
            text = viewState.cliente.razaoSocial ?: "",
            onTextChanged = onRazaoSocalChanged,
            errorMessage = null,
            enabled = true
        )
        Spacer(modifier = Modifier.height(12.dp))

        NomeFantasiaInput(
            text = viewState.cliente.nomeFantasia ?: "",
            onTextChanged = onNomeFantasiaChanged,
            errorMessage = null,
            enabled = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        CpfCnpjInput(
            text = viewState.cliente.cnpjCpf ?: "",
            onTextChanged = onCnpjCpfChanged,
            errorMessage = null,
            enabled = true
        )
        Spacer(modifier = Modifier.height(12.dp))

        EmailInput(
            text = viewState.cliente.email ?: "",
            onTextChanged = onEmailChanged,
            errorMessage = null,
            enabled = true
        )
        Spacer(modifier = Modifier.height(12.dp))

        TelefoneInput(
            textTelefone1Ddd = viewState.cliente.telefone1Ddd ?: "",
            textTelefone1Numero = viewState.cliente.telefone1Numero ?: "",
            onTelefone1DddChanged,
            onTelefone1Numero,
            errorMessage = null,
            enabled = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        PrimaryButton(
            onClick = onBtnClicked,
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
) {
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
) {
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
) {
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
) {
    AppTextField(
        text = text,
        onTextChanged = onTextChanged,
        errorMessage = errorMessage,
        labelText = "Username",
        enabled = enabled
    )
}

@Composable
fun TelefoneInput(
    textTelefone1Ddd: String,
    textTelefone1Numero: String,
    onTelefone1DddChanged: (String) -> Unit,
    onTelefone1NumeroChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean
) {

    // esses campos deveriam ficar em uma Row
    // , cada campo com tamanhos diferentes

    AppTextField(
        modifier = Modifier.size(15.dp),
        text = textTelefone1Ddd,
        onTextChanged = onTelefone1DddChanged,
        errorMessage = errorMessage,
        labelText = "ddd",
        enabled = enabled
    )
    AppTextField(
        modifier = Modifier.size(30.dp),
        text = textTelefone1Numero,
        onTextChanged = onTelefone1NumeroChanged,
        errorMessage = errorMessage,
        labelText = "Telefone",
        enabled = enabled
    )
}
