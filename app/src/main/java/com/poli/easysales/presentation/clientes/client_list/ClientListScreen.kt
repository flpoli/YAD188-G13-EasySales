package com.poli.easysales.presentation.clientes.client_list

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.presentation.clientes.client_list.components.ListContent
import com.poli.easysales.presentation.components.EmptyScreen
import com.poli.easysales.presentation.components.LoadingProgressIndicator
import com.poli.easysales.presentation.main_screen.components.TopBar

@Composable
fun ClientListScreen(
    navController: NavHostController,
    viewModel: ClientListViewModel = hiltViewModel()
) {

    val allClientes = viewModel.clientes.collectAsLazyPagingItems()

    Scaffold(

//        topBar = { TopBar(navController = navController, onNavigationIconClick = {}) }

    ) {

        ListContent(
            navController = navController,
            cliente = allClientes
        )
    }


    
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

                LoadingProgressIndicator()
                false
            }
            error != null -> {
                EmptyScreen(error = error)
                false
            }
            clientes.itemCount < 1 -> {
                EmptyScreen(error = LoadState.Error(Throwable("Parece que não há cadastros, vamos cadastrar?")))
                return false
            }
            else -> true
        }
    }
}

