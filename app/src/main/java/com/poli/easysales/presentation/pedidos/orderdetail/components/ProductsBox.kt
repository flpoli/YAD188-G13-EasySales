package com.poli.easysales.presentation.pedidos.orderdetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.poli.easysales.domain.model.pedidos.Produto
import com.poli.easysales.presentation.util.trimLeadingZeros

@Composable
fun ProductsBox(

    produto: Produto
) {

    Row() {

        Text(text = produto.codigo ?: "")

        Divider(
            thickness = 10.dp,
            modifier = Modifier.width(1.dp).fillMaxWidth()

        )

        Text(text = produto.descricao ?: "")

        Column() {

            Text(text = trimLeadingZeros(produto.quantidade.toString()))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductsBox() {

    val previewProduct = Produto(
        codigo = "123456",
        descricao = "Agulha de metal",
        valorUnitario = 50.6,
        valorTotal = 3542.00,
        quantidade = 70,
        unidade = "UN",
        percentualDesconto = 10.0,
        ncm = "00.0000.0000",
        ean = "7898067541191"

    )

    ProductsBox(
        produto = previewProduct
    )
}
