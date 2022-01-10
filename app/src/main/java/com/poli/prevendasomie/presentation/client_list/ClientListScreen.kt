package com.poli.prevendasomie.presentation.client_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue // muito importante ao utilizar "by remember"

import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.poli.prevendasomie.data.remote.responses.ClientesCadastro

@Composable
fun ClientListScreen(
    navController: NavController,
    viewModel: ClientListViewModel = hiltViewModel()
) {

    ClientListItem(navController = navController)



}

@Composable
fun ClientListItem(
    navController: NavController,
    viewModel: ClientListViewModel = hiltViewModel(),

    )

{
    val clientList by  remember { viewModel.clientList } // = vs by

    LazyColumn(){

        val itemCount = clientList.size

        items(itemCount) {
            viewModel.loadClientList()
            ClientRow(rowIndex = it, entries = clientList, navController = navController)
        }



    }

}

@Composable
fun ClientRow(
    rowIndex: Int,
    entries: List<ClientesCadastro>,
    navController: NavController
){

    Column {
        Row {
            ClientEntry(entry = entries[rowIndex], navController = navController)
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Composable
fun ClientEntry(
    entry: ClientesCadastro,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ClientListViewModel = hiltViewModel()
){

    Text(
        text = entry.nomeFantasia,
        modifier = Modifier.fillMaxWidth()
    )

}