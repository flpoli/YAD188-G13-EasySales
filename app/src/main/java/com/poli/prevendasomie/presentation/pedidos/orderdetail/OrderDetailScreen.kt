package com.poli.prevendasomie.presentation.pedidos.orderdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.poli.prevendasomie.presentation.pedidos.orderdetail.components.ProductsBox
import com.poli.prevendasomie.presentation.util.trimLeadingZeros

@Composable
fun OrderDetailScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: OrderDetailViewModel = hiltViewModel()
) {

    val selectedOrder by viewModel.selectedOrder.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
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
