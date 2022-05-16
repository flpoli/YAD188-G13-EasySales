package com.poli.prevendasomie.presentation.pedidos.searchclient

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.paging.compose.items

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro
import com.poli.prevendasomie.navigation.NavigateForResult
import com.poli.prevendasomie.navigation.Screen
import com.poli.prevendasomie.presentation.components.EmptyScreen
import com.poli.prevendasomie.presentation.pedidos.components.SelectableClientItem

@Composable
fun ClientSelectionScreen(
    viewModel: ClientSelectionViewModel = hiltViewModel()
){

    val clientes = viewModel.clientes?.collectAsLazyPagingItems()


    if (clientes != null) {
        ListClients(cliente = clientes)
    }


}

@Composable
fun ListClients(
    cliente: LazyPagingItems<ClientesCadastro>,
){

    val result = handlePagingResult(clientes = cliente)

    if(result){

    LazyColumn(){

        items(
            items  = cliente,
            key = {cliente -> cliente.id}

        ){

            cliente -> cliente?.let {

                Text(
                    text = cliente.nomeFantasia ?: ""
                )
        }
    }
    }

}}
@Composable
fun handlePagingResult(clientes: LazyPagingItems<ClientesCadastro>,): Boolean {

    clientes.apply {

        val error = when {

            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error

            else -> null
        }

        return when {

            loadState.refresh is LoadState.Loading -> {
                false
            }
            error != null -> {
                EmptyScreen(error = error)
                false
            }
            clientes.itemCount < 1 -> {
                EmptyScreen()
                false
            }
            else -> true
        }
    }
}