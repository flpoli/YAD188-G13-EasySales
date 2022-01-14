package com.poli.prevendasomie.presentation.client_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.poli.prevendasomie.presentation.client_list.components.ClientListItem

@Composable
fun ClientListScreen(
    navController: NavController,
    viewModel: ClientListViewModel = hiltViewModel()
) {

    ClientListItem(navController = navController)
    AddClientFab()

}


@Composable
fun AddClientFab() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        FloatingActionButton(

            onClick = { /*do something*/ },
            modifier = Modifier

        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = null
            )


        }
    }


}


