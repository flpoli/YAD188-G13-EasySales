package com.poli.easysales.presentation.produtos.productslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro
import com.poli.easysales.navigation.Screen
import com.poli.easysales.presentation.components.EmptyScreen

@Composable
fun ProductListScreen(
    navController: NavHostController,
    viewModel: ProductsListViewModel = hiltViewModel()
) {

    val allProducts = viewModel.produtos?.collectAsLazyPagingItems()

    if (allProducts != null) {
        ListContent(navController = navController, produto = allProducts)
    }
}

@Composable
fun ListContent(
    navController: NavController,
    produto: LazyPagingItems<ProdutoServicoCadastro>
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
                EmptyScreen(error = error)
                false
            }
            produtos.itemCount < 1 -> {
                EmptyScreen()
                false
            }
            else -> true
        }
    }
}
