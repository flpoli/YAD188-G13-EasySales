package com.poli.easysales.presentation.clientes.client_list.components

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissState
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Icon
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.ThresholdConfig
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
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
    onDismiss: (Long) -> Unit,
    modifier: Modifier = Modifier
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
                                    onDismiss= {onDismiss(cliente?.codClienteOmie!!)},
                                    cliente = cliente!!
                                )
                            }


            }
        }
    }



