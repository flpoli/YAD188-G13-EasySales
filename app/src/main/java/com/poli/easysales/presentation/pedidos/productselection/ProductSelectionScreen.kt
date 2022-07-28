package com.poli.easysales.presentation.pedidos.productselection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.easysales.core.UiEvent
import com.poli.easysales.presentation.components.PrimaryButton
import com.poli.easysales.presentation.pedidos.OrderOverviewEvent
import com.poli.easysales.presentation.pedidos.OrdersFormViewModel

@Composable
fun ProductSelectionScreen(

    navController: NavHostController,
    productsViewModel: ProductSelectionViewModel = hiltViewModel(),
    orderViewModel: OrdersFormViewModel = hiltViewModel()

) {

    val state = productsViewModel.state

    val selecionados = state.selectableProduct.filter { it.isSelected }

    LaunchedEffect(key1 = true) {

        productsViewModel.loadProductList()
        productsViewModel.uiEvent.collect { event ->

            when (event) {

                is UiEvent.NavigateUp -> { navController.popBackStack() }
                else -> Unit
            }
        }
    }

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn(
            contentPadding = PaddingValues(8.dp),
            modifier = Modifier.fillMaxHeight(.9f)

        ) {

            items(state.selectableProduct) {

                    produto ->
                SelectableProductItem(
                    selectableProductUiState = produto,
                    onClick = {
                    },
                    onQuantityChange = {
                        productsViewModel.onEvent(ProductSelectionEvent.OnAmountForProductChange(produto.produto, it))
                    },
                    onSelectProduct = {

                        productsViewModel.onEvent(ProductSelectionEvent.OnSelectProduct(produto.produto))
                    }
                )
            }
        }

        PrimaryButton(
            text = "Finalizar seleção",
            onClick = {

                productsViewModel.onEvent(ProductSelectionEvent.OnFinishSelection(selecionados))
                orderViewModel.onEvent(OrderOverviewEvent.OnProductSelected(selecionados))
                navController.popBackStack()
            }

        )
    }
}
