package com.poli.easysales.presentation.pedidos.clientselection

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.easysales.core.UiEvent
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.presentation.pedidos.OrderOverviewEvent
import com.poli.easysales.presentation.pedidos.OrdersFormViewModel

@Composable
fun ClientSelectionScreen(
    navController: NavHostController,
    viewModel: OrdersFormViewModel = hiltViewModel(),

    ) {

    LaunchedEffect(key1 = true) {

        viewModel.loadClientList()
        viewModel.uiEvent.collect { event ->

            when (event) {

                is UiEvent.NavigateUp -> {navController.popBackStack()}
                else -> Unit
            }
        }
    }

    val clientState = viewModel.clientState



    LazyColumn(modifier = Modifier.padding()) {

        items(clientState.selectableClient) {

                cliente ->
            SelectableClientItem(
                selectableClientUiState = cliente,
                onClick = {

                    viewModel.onEvent(OrderOverviewEvent.OnClientSelected(cliente.cliente))
                }
            )
        }
    }
}
