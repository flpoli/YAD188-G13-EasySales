package com.poli.prevendasomie.presentation.clientes.client_list

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.presentation.clientes.client_list.components.ClientListItem
import com.poli.prevendasomie.presentation.components.EmptyScreen

@Composable
fun ClientListScreen(
    navController: NavController,
    viewModel: ClientListViewModel = hiltViewModel()
) {

    val allClientes = viewModel.clientes?.collectAsLazyPagingItems()

    ClientListItem(
        navController = navController,
        cliente = allClientes
    )
}

@Composable
fun handlePagingResult(clientes: LazyPagingItems<ClientesCadastro>): Boolean {

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
                return false
            }
            else -> true
        }
    }
}
