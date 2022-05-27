package com.poli.prevendasomie.presentation.pedidos.productselection

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.prevendasomie.navigation.Screen
import com.poli.prevendasomie.presentation.pedidos.clientselection.SelectableClientItem

@Composable
fun ProductSelectionScreen(

    navController: NavHostController,
    viewModel: ProductSelectionViewModel = hiltViewModel()


){

    val state = viewModel.state

    LazyColumn(modifier = Modifier.padding()) {

        items(state.selectableProduct) {

                produto ->
            SelectableProductItem(
                selectableProductUiState = produto,
                onClick = {

                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        key = "produto",
                        value = produto.produto
                    )
                    navController.navigate(Screen.OrderFormScreen.route)

                }
            )
        }
    }

}