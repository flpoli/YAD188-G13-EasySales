package com.poli.easysales.presentation.clientes.cliente_form

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Upload
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.dokar.chiptextfield.Chip
import com.dokar.chiptextfield.ChipTextFieldState
import com.dokar.chiptextfield.OutlinedChipTextField
import com.dokar.chiptextfield.rememberChipTextFieldState
import com.poli.easysales.core.UiEvent
import com.poli.easysales.core.getString
import com.poli.easysales.domain.model.clientes.Tag
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.navigation.Screen
import com.poli.easysales.presentation.components.AppScaffold
import com.poli.easysales.presentation.components.AppTextField
import com.poli.easysales.presentation.components.EndOfScreen
import com.poli.easysales.presentation.components.PrimaryButton
import com.poli.easysales.ui.theme.LocalSpacing
import com.poli.easysales.ui.theme.TextFieldShape
import kotlinx.coroutines.CoroutineScope

@Composable
fun ClientFormScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    preferences: Preferences,
    viewModel: ClientFormViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    val tagState = rememberChipTextFieldState<Chip>(viewModel.clientTags.chips)
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

                }
                is UiEvent.NavigateUp -> {
                        navController.popBackStack()
                }
            }
        }
    }

    AppScaffold(
        scaffoldState = scaffoldState,
        navController = navController,
        scope = scope,
        preferences = preferences,
        showFab = false

    ) {

            paddingValues ->
        InputColumn(
            viewState = viewState.value,
            onEmailChanged = viewModel::onEmailChanged,
            onRazaoSocialChanged = viewModel::onRazaoSocialChanged,
            onNomeFantasiaChanged = viewModel::onNomeFantasiaChanged,
            onCnpjCpfChanged = viewModel::onCnpjCpfChanged,
            onTelefone1DddChanged = viewModel::onTelefone1DddChanged,
            onTelefone1Numero = viewModel::ontelefone1NumeroChanged,
            onTagChanged = viewModel::onTagsChanged,
            onBairroChanged = viewModel::onBairroChanged,
            onEnderecoChanged = viewModel::onEnderecoChanged,
            onNumeroChanged = viewModel::onEnderecoNumeroChanged,
            onCidadeChanged = viewModel::onCidadeChanged,
            onCepChanged = viewModel::onCepChanged,
            onSearchAddress = viewModel::searchAddress,
            onComplementoChanged = viewModel::onComplementoChanged,
            onEstadoChanged = viewModel::onEstadoChanged,
            clientTag = tagState,
            onBtnClicked = viewModel::onRegisterClicked,
            modifier = Modifier.padding(paddingValues)

        )
    }
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
    onTagChanged: (String, String) -> Unit,
    onEnderecoChanged: (String) -> Unit,
    onNumeroChanged: (String) -> Unit,
    onCepChanged: (String) -> Unit,
    onEstadoChanged: (String) -> Unit,
    onBairroChanged: (String) -> Unit,
    onComplementoChanged: (String) -> Unit,
    onSearchAddress: () -> Unit,
    onCidadeChanged: (String) -> Unit,
    clientTag: ChipTextFieldState<Chip>,
    onBtnClicked: () -> Unit,
    modifier: Modifier = Modifier

) {



    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 15.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item() {

            Spacer(modifier = Modifier.height(6.dp))

            RazaoSocialInput(
                text = viewState.cliente.razaoSocial ?: "",
                onTextChanged = onRazaoSocialChanged,
                errorMessage = null,
                enabled = true
            )
            Spacer(modifier = Modifier.height(4.dp))

            NomeFantasiaInput(
                text = viewState.cliente.nomeFantasia ?: "",
                onTextChanged = onNomeFantasiaChanged,
                errorMessage = null,
                enabled = true
            )

            Spacer(modifier = Modifier.height(4.dp))

            CpfCnpjInput(
                text = viewState.cliente.cnpjCpf ?: "",
                onTextChanged = onCnpjCpfChanged,
                errorMessage = null,
                enabled = true
            )
            Spacer(modifier = Modifier.height(4.dp))

            EmailInput(
                text = viewState.cliente.email ?: "",
                onTextChanged = onEmailChanged,
                errorMessage = null,
                enabled = true
            )
            Spacer(modifier = Modifier.height(4.dp))

            TelefoneInput(
                textTelefone1Ddd = viewState.cliente.telefone1Ddd ?: "",
                textTelefone1Numero = viewState.cliente.telefone1Numero ?: "",
                onTelefone1DddChanged = onTelefone1DddChanged,
                onTelefone1NumeroChanged = onTelefone1Numero,
                errorMessage = null,
                enabled = true
            )

            Spacer(modifier = Modifier.height(4.dp))

            EnderecoInput(
                endereco = viewState.cliente.endereco.orEmpty(),
                numero = viewState.cliente.enderecoNumero.orEmpty(),
                bairro = viewState.cliente.bairro.orEmpty(),
                cidade = viewState.cliente.cidade.orEmpty(),
                estado = viewState.cliente.estado.orEmpty(),
                complemento = viewState.cliente.complemento.orEmpty(),
                cep = viewState.cliente.cep.orEmpty(),
                onEnderecoChanged = onEnderecoChanged,
                onNumeroChanged = onNumeroChanged,
                onBairroChanged = onBairroChanged,
                onCidadeChanged = onCidadeChanged,
                onEstadoChanged = onEstadoChanged,
                onComplementoChanged = onComplementoChanged,
                onCepChanged = onCepChanged,
                onSearchAddress = onSearchAddress,
                errorMessage = null,
                enabled = true
            )

            Spacer(modifier = Modifier.height(4.dp))

            TagInputField(

                tags = viewState.cliente.tags!!,
                onTagsChange = onTagChanged,

            )

            Spacer(modifier = Modifier.height(4.dp))

            PrimaryButton(
                onClick = { onBtnClicked() },
                text = "cadastrar",
            )

            EndOfScreen()
        }
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
fun EnderecoInput(
    endereco: String,
    numero: String,
    bairro: String,
    cidade: String,
    estado: String,
    complemento: String,
    cep: String,
    onSearchAddress: () -> Unit,
    onEnderecoChanged: (String) -> Unit,
    onNumeroChanged: (String) -> Unit,
    onBairroChanged: (String) -> Unit,
    onCidadeChanged: (String) -> Unit,
    onEstadoChanged: (String) -> Unit,
    onComplementoChanged: (String) -> Unit,
    onCepChanged: (String) -> Unit,
    errorMessage: String?,
    enabled: Boolean
) {

    val conf = LocalConfiguration.current

    Column {

        AppTextField(
            text = endereco,
            onTextChanged = onEnderecoChanged,
            errorMessage = errorMessage,
            labelText = "Endereco",
            enabled = enabled,
            trailingIcon = {}
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

//            AppTextField(
//                text = numero,
//                onTextChanged = onEnderecoChanged,
//                errorMessage = errorMessage,
//                labelText = "Número",
//                enabled = enabled,
//                trailingIcon = {},
//                modifier = Modifier.width(conf.screenWidthDp.dp * .5f),
//
//                )

            AppTextField(
                text = complemento,
                onTextChanged = onComplementoChanged,
                errorMessage = errorMessage,
                labelText = "Complemento",
                enabled = enabled,
                trailingIcon = {},
                modifier = Modifier.width(conf.screenWidthDp.dp * .5f),

            )
            AppTextField(
                text = cep,
                onTextChanged = onCepChanged,
                errorMessage = errorMessage,
                labelText = "Cep",
                enabled = enabled,
                trailingIcon = {
                    IconButton(onClick = { onSearchAddress() }) {
                        Icon(
                            Icons.Filled.Search,
                            contentDescription = null,
                            tint = Red
                        )

                    }

                },
                modifier = Modifier.width(conf.screenWidthDp.dp * .4f),
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            AppTextField(
                text = estado,
                onTextChanged = onEstadoChanged,
                errorMessage = errorMessage,
                labelText = "UF",
                enabled = enabled,
                trailingIcon = {},
                modifier = Modifier.width(conf.screenWidthDp.dp * .3f),
            )
            AppTextField(
                text = cidade,
                onTextChanged = onCidadeChanged,
                errorMessage = errorMessage,
                labelText = "Cidade",
                enabled = enabled,
                trailingIcon = {},
                modifier = Modifier.width(conf.screenWidthDp.dp * .6f),

            )
        }
    }
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

@Composable
fun TagInputField(

    tags: List<Tag>,
    onTagsChange: (String, String) -> Unit,

) {

    val state = rememberChipTextFieldState<Chip>()

    OutlinedChipTextField(
        state = state,
        onCreateChip = {
            onTagsChange("add", it)
            Chip(it)
        },
        shape = TextFieldShape,
        label = { Text(text = "Tags") },
        onChipClick = {
            onTagsChange("delete", state.textFieldValue.text)
        }

    )
}

@Preview(showBackground = true)
@Composable
fun PreviewEnderecoInput() {

    EnderecoInput(
        endereco = "Av. Paulista",
        numero = "819",
        bairro = "Centro",
        cidade = "São Paulo",
        estado = "SP",
        complemento = "Apto 50",
        cep = "02920-45",
        onSearchAddress = {},
        onEnderecoChanged = {},
        onNumeroChanged = {},
        onBairroChanged = {},
        onCidadeChanged = {},
        onEstadoChanged = {},
        onComplementoChanged = {},
        onCepChanged = {},
        errorMessage = "Erro",
        enabled = true
    )
}
