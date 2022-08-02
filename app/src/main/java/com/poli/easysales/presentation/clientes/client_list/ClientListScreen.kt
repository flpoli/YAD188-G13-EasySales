package com.poli.easysales.presentation.clientes.client_list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.poli.easysales.core.UiEvent
import com.poli.easysales.core.getString
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.presentation.clientes.client_list.components.ListContent
import com.poli.easysales.presentation.components.AppScaffold
import com.poli.easysales.presentation.components.EmptyScreen
import com.poli.easysales.presentation.components.LoadingProgressIndicator
import kotlinx.coroutines.CoroutineScope

@Composable
fun ClientListScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    preferences: Preferences,
    scope: CoroutineScope,
    viewModel: ClientListViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val allClientes = viewModel.clientes.collectAsLazyPagingItems()

    LaunchedEffect(key1 = true) {

        viewModel.uiEvent.collect {

                event ->
            when (event) {

                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.getString(context)
                    )
                }
                else -> Unit
            }
        }
    }
    AppScaffold(
        scaffoldState = scaffoldState,
        navController = navController,
        scope = scope,
        preferences = preferences

    ) {

            paddingValues ->
        ListContent(
            navController = navController,
            cliente = allClientes,
            onDismiss = viewModel::onSwipeToDelete,
            modifier = Modifier.padding(paddingValues)
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
