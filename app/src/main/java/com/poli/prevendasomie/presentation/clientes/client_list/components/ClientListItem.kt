package com.poli.prevendasomie.presentation.clientes.client_list.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.navigation.Screen
import com.poli.prevendasomie.presentation.clientes.client_list.handlePagingResult

@Composable
fun ClientListItem(
    navController: NavController,
    cliente: LazyPagingItems<ClientesCadastro>?
) {

    val result = handlePagingResult(clientes = cliente!!)
    if (result) {
        LazyColumn(modifier = Modifier.padding()) {

            items(
                items = cliente,
                key = { cliente -> cliente.id }
            ) {

                    cliente ->
                cliente?.let {
                    ClientRow(
                        entries = cliente,
                        navController = navController,
                        onItemClick = {
                            navController.navigate(Screen.ClientDetailScreen.passClientId(clientId = cliente.id))
                        }
                    )
                    Divider(color = Color.Black, thickness = 1.dp)
                }
            }
        }
    }
}
