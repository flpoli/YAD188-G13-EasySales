package com.poli.prevendasomie.presentation.client_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue // muito importante ao utilizar "by remember"
import androidx.compose.runtime.* // muito importante ao utilizar "by remember"

import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.poli.prevendasomie.data.models.ClientListEntry
import com.poli.prevendasomie.data.models.ClientesCadastroEntry

@Composable
fun ClientListScreen(
    navController: NavController,
    viewModel: ClientListViewModel = hiltViewModel()
) {
//    //val state = viewModel.state.value
//    Box(modifier = Modifier.fillMaxSize()) {
//        LazyColumn(modifier = Modifier.fillMaxSize()) {
////            items(state.coins) { client ->
////                ClientListItem(
////                    client = client,
////
////                )
////            }
//        }
//
//    }

    ClientListItem()
}

@Composable
fun ClientListItem(
    viewModel: ClientListViewModel = hiltViewModel(),

    )
{
    val clientList by  remember {   // = vs by

        viewModel.clientList
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()

            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${clientList[0]?.cnpjCpf}", // why??? java.lang.IndexOutOfBoundsException: Empty list doesn't contain element at index 0.
            style = MaterialTheme.typography.body1,

            )

    }
}