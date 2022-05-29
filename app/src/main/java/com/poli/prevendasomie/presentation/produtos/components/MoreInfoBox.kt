package com.poli.prevendasomie.presentation.produtos.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.HorizontalRule
import androidx.compose.material.icons.filled.OpenInFull

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import com.poli.prevendasomie.domain.model.produtos.ProdutoServicoCadastro

@Composable
fun MoreInfoBox(

    selectedProduct: ProdutoServicoCadastro


){

    Column(){

        if(selectedProduct.descrDetalhada?.isNotEmpty() == true) {
            Text(
                text = "Descrição detalhada:"
            )
            Text(
                text = selectedProduct.descrDetalhada ?: "sem detalhe"
            )
        }


        Text(
            text = "Dimensões"
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,

            ){


            InfoBox(
                icon = Icons.Default.Height,
                iconColor = MaterialTheme.colors.primary,
                bigText = selectedProduct.altura.toString(),
                smallText = "altura",
                textColor = Color.Black
            )

            InfoBox(
                icon = Icons.Default.HorizontalRule,
                iconColor = MaterialTheme.colors.primary,
                bigText = selectedProduct.largura.toString(),
                smallText = "largura",
                textColor = Color.Black
            )

            InfoBox(
                icon = Icons.Default.OpenInFull,
                iconColor = MaterialTheme.colors.primary,
                bigText = selectedProduct.profundidade.toString(),
                smallText = "profundidade",
                textColor = Color.Black
            )


        }




    }

}