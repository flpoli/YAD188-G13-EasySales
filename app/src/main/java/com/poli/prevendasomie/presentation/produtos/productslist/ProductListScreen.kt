package com.poli.prevendasomie.presentation.produtos.productslist

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ProductListScreen(
    navController: NavHostController,
    viewModel: ProductsListViewModel = hiltViewModel()
) {

    viewModel.loadProductsList()

    val state by remember { viewModel.state }

    Text(
        text = state.produtos?.produtoServicoCadastro.toString()
    )
}
