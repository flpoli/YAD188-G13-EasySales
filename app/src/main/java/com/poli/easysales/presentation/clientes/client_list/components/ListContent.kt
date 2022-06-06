package com.poli.easysales.presentation.clientes.client_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.navigation.Screen
import com.poli.easysales.presentation.clientes.client_list.handlePagingResult

@Composable
fun ListContent(
    navController: NavController,
    cliente: LazyPagingItems<ClientesCadastro>?
) {

    val result = handlePagingResult(clientes = cliente!!)
    if (result) {
        LazyColumn(
            contentPadding = PaddingValues(all = 10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {

            items(
                items = cliente,

            ) {

                    cliente ->

                ClientListItem(
                    onItemClick = {
                        navController.navigate(
                            Screen.ClientDetailScreen
                                .passClientId(clientId = cliente?.codClienteOmie!!)
                        )
                    },
                    cliente = cliente!!
                )
            }
        }
    }
}
