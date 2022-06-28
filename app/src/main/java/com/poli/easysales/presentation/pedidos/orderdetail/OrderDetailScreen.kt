package com.poli.easysales.presentation.pedidos.orderdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.presentation.components.AppScaffold
import com.poli.easysales.presentation.pedidos.orderdetail.components.ProductsBox
import com.poli.easysales.presentation.util.trimLeadingZeros
import kotlinx.coroutines.CoroutineScope

@Composable
fun OrderDetailScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    preferences: Preferences,
    scope: CoroutineScope,
    modifier: Modifier = Modifier,
    viewModel: OrderDetailViewModel = hiltViewModel()
) {

    val selectedOrder by viewModel.selectedOrder.collectAsState()

    AppScaffold(
        scaffoldState = scaffoldState,
        navController = navController,
        scope = scope,
        preferences = preferences

    ) {
            paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(paddingValues)
        ) {

            Text(
                text = "Pedido N° ${trimLeadingZeros(selectedOrder?.cabecalho?.numeroPedido)}"
            )

            Text(text = "Cliente")

            // Text(text = selectedOrder?.cabecalho?.codigoCliente)

            Text(text = "Produtos:")

            selectedOrder?.det?.forEach {

                    produto ->

                produto.produto?.let {

                    ProductsBox(produto = it)
                }
            }
        }
    }
}
