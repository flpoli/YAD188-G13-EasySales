package com.poli.easysales.presentation.pedidos.clientselection

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.easysales.core.UiEvent
import com.poli.easysales.presentation.pedidos.OrderOverviewEvent
import com.poli.easysales.presentation.pedidos.OrdersFormViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch
import kotlinx.coroutines.newCoroutineContext
import kotlin.coroutines.CoroutineContext

@Composable
fun ClientSelectionScreen(
    navController: NavHostController,
    clientsViewModel: ClientSelectionViewModel = hiltViewModel(),
    orderViewModel: OrdersFormViewModel = hiltViewModel(),

    ) {

    LaunchedEffect(key1 = orderViewModel.state) {

        orderViewModel.uiEvent.collect { event ->

            when (event) {

                is UiEvent.NavigateUp -> {}
                else -> Unit
            }
        }
    }

    val clientState = clientsViewModel.state



    LazyColumn(modifier = Modifier.padding()) {

        items(clientState.selectableClient) {

                cliente ->
            SelectableClientItem(
                selectableClientUiState = cliente,
                onClick = {


                    orderViewModel.onEvent(OrderOverviewEvent.OnClientSelected(cliente.cliente))
                    navController.popBackStack()
                }
            )
        }
    }
}
