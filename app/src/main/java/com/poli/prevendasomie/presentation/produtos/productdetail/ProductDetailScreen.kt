package com.poli.prevendasomie.presentation.produtos.productdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController

@Composable
fun ProductDetailScreen(

    navController: NavHostController,
    viewModel: ProductDetailViewModel = hiltViewModel()

){

    val selectedProduct by viewModel.selectedProduct.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ){


        Text(
            text = " Código do produto: ${ selectedProduct?.codigo ?: "" }"
        )

        Text(
            text = "Descrição: \n${ selectedProduct?.descricao ?: "" }"
        )
        Text(
            text = "Desc Detalhada: \n${ selectedProduct?.descrDetalhada ?: "sem detalhe" }"
        )

        Text(
            text = "Valor unitário: R$${ selectedProduct?.valorUnitario ?: "sem detalhe" }"
        )

        Text(
            text = "Estoque: ${ selectedProduct?.quantidadeEstoque }${selectedProduct?.unidade}"
        )



    }


}