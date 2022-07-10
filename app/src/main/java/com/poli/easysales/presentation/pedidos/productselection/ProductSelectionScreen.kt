package com.poli.easysales.presentation.pedidos.productselection

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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

@Composable
fun ProductSelectionScreen(

    navController: NavHostController,
    viewModel: ProductSelectionViewModel = hiltViewModel()

) {

    val state = viewModel.state
    val listaProdutos: MutableList<ProdutoServicoCadastro> = mutableListOf()

    fun onSelectProduct(products: ProdutoServicoCadastro?) {


        

        if (products != null)
            listaProdutos.add(products)



        Log.d("onSelected - list", "$listaProdutos")
        Log.d("onSelected - list size", "${listaProdutos?.size}")
    }

    fun onFinishSelection(listaProdutos: MutableList<ProdutoServicoCadastro>) {



            navController.previousBackStackEntry?.savedStateHandle?.let {

                it["produtos"] = listaProdutos
            }

        navController.popBackStack()
    }





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

                        val x = produto.copy(
                            produto = produto.produto,
                            isSelected = !produto.isSelected,
                            amount = produto.amount
                        )

                        Log.d("PRODUTO COPY", "$x")

                        onSelectProduct(x.produto)
                    },
                    onQuantityChange = {}
                )
            }



        }

        PrimaryButton(
            text = "Finalizar seleção",
            onClick = { onFinishSelection(listaProdutos)},
            )
    }




    
}
