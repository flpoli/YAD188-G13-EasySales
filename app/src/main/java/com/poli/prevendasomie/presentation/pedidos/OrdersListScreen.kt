package com.poli.prevendasomie.presentation.pedidos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.domain.model.pedidos.PedidoVendaProduto
import com.poli.prevendasomie.navigation.Screen
import com.poli.prevendasomie.presentation.components.EmptyScreen

@Composable
fun OrdersListScreen(
    navController: NavHostController,
    viewModel: OrdersListViewModel = hiltViewModel(),

    // Navigation callback:
    //onNavigate: (UiEvent.Navigate) -> Unit
    // should try this instead of passing navController down the composable tree. Lets see...
) {

    val allOrders = viewModel.pedidos.collectAsLazyPagingItems()

    ListContent(pedidos = allOrders)
    OrderFab(navController = navController)
}

@Composable
fun ListContent(
    pedidos: LazyPagingItems<PedidoVendaProduto>
) {

    val result = handlePagingResult(pedidos = pedidos)

    if (result) {
        LazyColumn(
            contentPadding = PaddingValues(all = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(
                items = pedidos,
                key = { pedidos -> pedidos.id }
            ) {

                    pedido ->
                        pedido?.let {

                            pedido.cabecalho.let {

                                if (it != null) {
                                    Text(
                                        text = it.numeroPedido.toString()
                                    )

                                }

                            }
                        }
            }
        }
    }


}

@Composable
fun OrderFab(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(

            onClick = { navController.navigate(Screen.OrderFormScreen.route) },
            modifier = Modifier

        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = null
            )
        }
    }
}

@Composable
fun handlePagingResult(pedidos: LazyPagingItems<PedidoVendaProduto>): Boolean {

    pedidos.apply {

        val error = when {

            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error

            else -> null
        }

        return when {

            loadState.refresh is LoadState.Loading -> {
                false
            }
            error != null -> {
                EmptyScreen(error = error)
                false
            }
            pedidos.itemCount < 1 -> {
                EmptyScreen()
                return false
            }
            else -> true
        }
    }
}
