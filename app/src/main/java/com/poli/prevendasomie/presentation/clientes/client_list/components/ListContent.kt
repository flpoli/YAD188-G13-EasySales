package com.poli.prevendasomie.presentation.clientes.client_list.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
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
fun ListContent(
    navController: NavController,
    cliente: LazyPagingItems<ClientesCadastro>?
) {

    val result = handlePagingResult(clientes = cliente!!)
    if (result) {
        LazyColumn(
            contentPadding = PaddingValues(all = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)

        ) {

            items(
                items = cliente,


            ) {

                    cliente ->

                ClientListItem(
                    onItemClick = {navController.navigate(Screen.ClientDetailScreen.passClientId(clientId = cliente?.codClienteOmie!!))},
                    cliente = cliente!!
                )

//                cliente?.let {
//                    ClientRow(
//                        entries = cliente,
//                        navController = navController,
//                        onItemClick = {
//                            if (cliente.codClienteOmie != null) {
//                                navController.navigate(
//                                    Screen.ClientDetailScreen.passClientId(
//                                        clientId = cliente.codClienteOmie
//                                    )
//                                )
//                            } else throw IllegalArgumentException("Cagou no navigate pq tirei o ID da model que era entity junto")
//                        }
//                    )
//                    Divider(color = Color.Black, thickness = 1.dp)
                }
            }
        }
    }

