package com.poli.easysales.presentation.produtos.productslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.navigation.Screen
import com.poli.easysales.presentation.components.AppScaffold
import com.poli.easysales.presentation.components.LoadingProgressIndicator
import kotlinx.coroutines.CoroutineScope

@Composable
fun ProductListScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    preferences: Preferences,
    scope: CoroutineScope,
    viewModel: ProductsListViewModel = hiltViewModel()
) {

    val allProducts = viewModel.produtos?.collectAsLazyPagingItems()

    AppScaffold(
        scaffoldState = scaffoldState,
        navController = navController,
        scope = scope,
        preferences = preferences

    ) {
        if (allProducts != null) {
            ListContent(
                navController = navController,
                produto = allProducts,
                modifier = Modifier.padding()
            )
        }
    }
}

@Composable
fun ListContent(
    navController: NavController,
    produto: LazyPagingItems<ProdutoServicoCadastro>,
    modifier: Modifier = Modifier
) {

    val result = handlePagingResult(produtos = produto)

    if (result) {
        LazyColumn(
            contentPadding = PaddingValues(all = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(
                items = produto,

            ) {

                    produto ->
                if (produto != null) {
                    ProductListItem(
                        onItemClick = {
                            navController.navigate(
                                Screen.ProductDetailScreen
                                    .passProductId(productId = produto.codigoProduto)
                            )
                        },
                        produto = produto
                    )
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(produtos: LazyPagingItems<ProdutoServicoCadastro>): Boolean {

    produtos.apply {

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

                false
            }
            produtos.itemCount < 1 -> {
                LoadingProgressIndicator()
                false
            }
            else -> true
        }
    }
}
