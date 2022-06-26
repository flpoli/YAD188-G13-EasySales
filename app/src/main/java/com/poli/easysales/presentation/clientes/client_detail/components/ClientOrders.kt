package com.poli.easysales.presentation.clientes.client_detail.components

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.navigation.Screen
import com.poli.easysales.presentation.components.EndOfScreen
import com.poli.easysales.presentation.pedidos.orderlist.OrderListItem

@Composable
fun ClientOrders(
    navController: NavHostController,
    orders: List<PedidoVendaProduto>
) {

    LazyColumn(
        contentPadding = PaddingValues(top = 16.dp, bottom = 36.dp)
    ) {

        item {

            orders.forEach {

                OrderListItem(
                    order = it,
                    onItemClick = {
                        Log.d("ORDER ID?", "${it.cabecalho.codigoPedido}")

                        try {

                            Log.d("ORDER ID - navgate?" ,"${it.cabecalho.codigoPedido}")

                            navController.navigate(Screen.OrderDetailScreen.passOrderId(it.cabecalho.codigoPedido!!))

                        }catch(e: Exception){

                            e.printStackTrace()
                        }

                    }
                )
            }

        }


    }
    EndOfScreen()

}
