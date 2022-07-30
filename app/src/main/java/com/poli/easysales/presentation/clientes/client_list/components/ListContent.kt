package com.poli.easysales.presentation.clientes.client_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.DismissState
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.navigation.Screen
import com.poli.easysales.presentation.clientes.client_list.handlePagingResult

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListContent(
    navController: NavController,
    cliente: LazyPagingItems<ClientesCadastro>?,
    modifier: Modifier = Modifier
) {

    var unread by remember { mutableStateOf(false) }
    val dismissState = rememberDismissState(
        confirmStateChange = {
            if (it == DismissValue.DismissedToEnd) unread = !unread
            it != DismissValue.DismissedToEnd
        }
    )

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

                    SwipeToDismiss(
                        state = dismissState,
                        background = {}
                    ) {
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
    }

