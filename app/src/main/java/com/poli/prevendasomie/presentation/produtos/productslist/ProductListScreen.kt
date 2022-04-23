package com.poli.prevendasomie.presentation.produtos.productslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro


@Composable
fun ProductListScreen(
    navController: NavHostController,
    viewModel: ProductsListViewModel = hiltViewModel()
) {

    val state by remember { viewModel.state }
    
    val allProducts = viewModel.produtos?.collectAsLazyPagingItems()

    if (allProducts != null) {
        ListContent(allProducts)
    }

}

@Composable
fun ListContent(
    produto: LazyPagingItems<ProdutoServicoCadastro>
){

    val result = handlePagingResult(produtos = produto)

    if(result){
        LazyColumn(
            contentPadding = PaddingValues(all = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            items(
                items = produto,
                key = {produto -> produto.codigoProduto}
            ){

                    produto -> produto?.let {


                produto.descricao?.let { it1 ->
                    Text(
                        text = it1
                    )
                }
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
            else -> true
            }

        }

    }


