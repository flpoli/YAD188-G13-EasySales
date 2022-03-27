package com.poli.prevendasomie.presentation.clientes.client_list.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.poli.prevendasomie.navigation.Screen
import com.poli.prevendasomie.presentation.clientes.client_list.ClientListViewModel

@Composable
fun ClientListItem(
    navController: NavController,
    viewModel: ClientListViewModel = hiltViewModel(),
) {
    val state by remember { viewModel.state }
    val endReached by remember { viewModel.endReached }
    val isLoading by remember { viewModel.isLoading }
    val loadError by remember { viewModel.loadError }
    val isSearching by remember { viewModel.isSearching }

//    SearchBar(
//        hint = "", // I cant make the hint disappears when box focused; how to?
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ){
//        viewModel.searchClientList(it)
//    }

//    Spacer(modifier = Modifier.height(16.dp))

    LazyColumn(modifier = Modifier.padding(top = 80.dp, end = 0.dp)) {

        val itemCount = state.clientes?.clientes?.size

        if (itemCount != null) {
            items(itemCount) {

                if (it >= itemCount - 1 && !endReached && !isLoading && !isSearching) {

                    viewModel.loadClientList()
                }
                ClientRow(
                    rowIndex = it,
                    entries = state.clientes?.clientes ?: emptyList(),
                    navController = navController,
                    onItemClick = {
                        navController.navigate(Screen.ClientDetailScreen.route + "/${state.clientes?.clientes}") // fix route params
                    }
                )
                Divider(color = Color.Black, thickness = 1.dp)
            }
        }
    }
}
