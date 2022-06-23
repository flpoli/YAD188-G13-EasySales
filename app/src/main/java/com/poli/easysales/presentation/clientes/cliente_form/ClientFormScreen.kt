package com.poli.easysales.presentation.clientes.cliente_form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.easysales.core.UiEvent
import com.poli.easysales.core.getString
import com.poli.easysales.presentation.components.AppTextField
import com.poli.easysales.presentation.components.PrimaryButton

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
        onRazaoSocialChanged = viewModel::onRazaoSocialChanged,
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
    onRazaoSocialChanged: (String) -> Unit,
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
            onTextChanged = onRazaoSocialChanged,
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
        enabled = enabled!!,
        trailingIcon = {}
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
        enabled = enabled,
        trailingIcon = {}
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
        enabled = enabled,
        trailingIcon = {}
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
        labelText = "Email",
        enabled = enabled,
        trailingIcon = {}
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
    val conf = LocalConfiguration.current
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()

    ) {
        AppTextField(
            modifier = Modifier.width(conf.screenWidthDp.dp * .3f),
            text = textTelefone1Ddd,
            onTextChanged = onTelefone1DddChanged,
            errorMessage = errorMessage,
            labelText = "ddd",
            enabled = enabled,
            trailingIcon = {}
        )
        AppTextField(
            modifier = Modifier.width(conf.screenWidthDp.dp * .7f),
            text = textTelefone1Numero,
            onTextChanged = onTelefone1NumeroChanged,
            errorMessage = errorMessage,
            labelText = "Telefone",
            enabled = enabled,
            trailingIcon = {}
        )
    }
}
