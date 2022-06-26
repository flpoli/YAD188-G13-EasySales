package com.poli.easysales.presentation.pedidos.orderlist

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.navigation.Screen
import com.poli.easysales.presentation.components.EmptyScreen
import com.poli.easysales.presentation.components.LoadingProgressIndicator
import io.sentry.Sentry

@Composable
fun OrdersListScreen(
    navController: NavHostController,
    viewModel: OrdersListViewModel = hiltViewModel(),

    // scaffoldState: ScaffoldState
    // Navigation callback:
    // onNavigate: (UiEvent.Navigate) -> Unit
    // should try this instead of passing navController down the composable tree. Lets see...
) {

    val allOrders = viewModel.pedidos.collectAsLazyPagingItems()

    ListContent(navController = navController, pedidos = allOrders)
}

@Composable
fun ListContent(
    navController: NavHostController,
    pedidos: LazyPagingItems<PedidoVendaProduto>
) {

    val result = handlePagingResult(pedidos = pedidos)

    if (result) {
        LazyColumn(
            contentPadding = PaddingValues(all = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {
            items(
                items = pedidos,
                key = { pedidos -> pedidos.id }
            ) {

                    pedido ->
                if (pedido != null) {
                    OrderListItem(
                        onItemClick = {

                            Log.d("ORDER LIST SCREEN", "${navController
                                .navigate(
                                    Screen.OrderDetailScreen.passOrderId(
                                        pedido.cabecalho.codigoPedido!!
                                    )
                                )}" )

                            navController
                                .navigate(
                                    Screen.OrderDetailScreen.passOrderId(
                                        pedido.cabecalho.codigoPedido
                                    )
                                )
                        },
                        order = pedido
                    )
                }
            }
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

                // scaffoldState.snackbarHostState.showSnackbar("a")
                EmptyScreen(error = error)

                Sentry.captureException(error.error)
                false
            }
            pedidos.itemCount < 1 -> {
                LoadingProgressIndicator()
                return false
            }
            else -> true
        }
    }
}
