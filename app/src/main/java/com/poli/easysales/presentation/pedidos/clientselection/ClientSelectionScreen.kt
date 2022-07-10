package com.poli.easysales.presentation.pedidos.clientselection

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.easysales.domain.model.clientes.ClientesCadastro

@Composable
fun ClientSelectionScreen(
    navController: NavHostController,
    // onSelectClient: (ClientesCadastro) -> Unit,
    viewModel: ClientSelectionViewModel = hiltViewModel(),

) {

    LaunchedEffect(key1 = true) {

        viewModel.uiEvent.collect { event ->

            when (event) {

                // is UiEvent.NavigateUp -> onNavigateUp()
                else -> Unit
            }
        }
    }

    val clientState = viewModel.state

    fun onSelectClient(cliente: ClientesCadastro?) {

        if (cliente != null) {

            navController.previousBackStackEntry?.savedStateHandle?.let {

                it["cliente"] = cliente
            }
        }
        navController.popBackStack()
    }

    LazyColumn(modifier = Modifier.padding()) {

        items(clientState.selectableClient) {

                cliente ->
            SelectableClientItem(
                selectableClientUiState = cliente,
                onClick = {
                    onSelectClient(cliente.cliente)
                }
            )
        }
    }
}
