package com.poli.prevendasomie.presentation.pedidos.clientselection

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.presentation.components.EmptyScreen
import com.poli.prevendasomie.presentation.pedidos.OrdersFormViewModel

@Composable
fun ClientSelectionScreen(
    onNavigateUp: () -> Unit,
    viewModel: ClientSelectionViewModel = hiltViewModel(),


) {

    LaunchedEffect(key1 = true) {

        viewModel.uiEvent.collect { event ->

            when (event) {

                is UiEvent.NavigateUp -> onNavigateUp()
                else -> Unit
            }
        }
    }

    val state = viewModel.state


        LazyColumn(modifier = Modifier.padding()) {

            items(state.selectableClient) {

                cliente ->
                    SelectableClientItem(
                        selectableClientUiState = cliente,
                        onClick = {
                            viewModel.onEvent(SelectionEvent.OnClientSelected(cliente.cliente))
                        }
                    )

            }
        }

}


