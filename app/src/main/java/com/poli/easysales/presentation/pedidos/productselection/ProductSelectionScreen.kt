package com.poli.easysales.presentation.pedidos.productselection

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro
import com.poli.easysales.presentation.components.PrimaryButton
import com.poli.easysales.presentation.pedidos.OrderOverviewEvent
import com.poli.easysales.presentation.pedidos.OrdersFormViewModel

@Composable
fun ProductSelectionScreen(

    navController: NavHostController,
    viewModel: ProductSelectionViewModel = hiltViewModel(),
    orderViewModel: OrdersFormViewModel = hiltViewModel()

) {

    val state = remember {
        viewModel.state
    }

    val selecionados = state.selectableProduct.filter { it.isSelected }


    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){

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
                        viewModel.onEvent(ProductSelectionEvent.OnAmountForProductChange(produto.produto, it))
                    },
                    onSelectProduct = {

                        viewModel.onEvent(ProductSelectionEvent.OnSelectProduct(produto.produto))

                    }
                )
            }



        }

        PrimaryButton(
            text = "Finalizar seleção",
            onClick = {

                viewModel.onEvent(ProductSelectionEvent.OnFinishSelection(selecionados))
                orderViewModel.onEvent(OrderOverviewEvent.OnProductSelected(selecionados))

            }

            )
    }




    
}
