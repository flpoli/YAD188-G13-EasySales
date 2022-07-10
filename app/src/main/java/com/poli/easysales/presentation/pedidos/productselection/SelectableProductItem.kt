package com.poli.easysales.presentation.pedidos.productselection

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.poli.easysales.data.remote.dto.produtos.Imagens
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro
import com.poli.easysales.ui.theme.LocalSpacing

@Composable
fun SelectableProductItem(

    selectableProductUiState: SelectableProductUiState,
    onClick: () -> Unit,
    onQuantityChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    val produto = selectableProductUiState.produto
    val spacing = LocalSpacing.current

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .padding(spacing.spaceExtraSmall)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(5.dp)
            )
            .background(MaterialTheme.colors.surface)
            .clickable {
                onClick()
                selectableProductUiState.isExpanded
            }
            .padding(end = spacing.spaceMedium)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(
                    text = produto.codigoProduto.toString()
                )
                Text(
                    text = produto.descricao!!
                )

                // mudar para AnimatedVisibility dps;

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    QuantityField(selectableProductUiState = selectableProductUiState, onQuantityChange = onQuantityChange)

                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "",
                            tint = Color.Green
                        )
                    }
                }
            }

            AnimatedVisibility(visible = selectableProductUiState.isExpanded) {

//                Column {
//                    Text(
//                        text = produto.codigoProduto.toString()
//                    )
//                    Text(
//                        text = produto.descricao!!
//                    )
            }
        }
    }
}


@Composable
fun QuantityField(
    selectableProductUiState: SelectableProductUiState,
    onQuantityChange: (String) -> Unit

    ){

    OutlinedTextField(

        value = selectableProductUiState.amount,
        onValueChange = { onQuantityChange(it) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        leadingIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "",
                    tint = Color.Red
                )
            }
        },

        trailingIcon = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.Green
                )
            }
        },
        modifier = Modifier
            .height(32.dp)
            .fillMaxWidth(.4f)
            .border(
                shape = RoundedCornerShape(5.dp),
                width = 0.5.dp,
                color = MaterialTheme.colors.onSurface
            )

    )


}


@Composable
@Preview(showBackground = true)
fun PreviewQuantityField(){

    val state = SelectableProductUiState(
        produto = ProdutoServicoCadastro(
            codigo = "123456",
            codigoProduto = 12345678,
            descricao = "Ração CatChow Frango",
            descrDetalhada = "Ração catchow frango 1kg",
            unidade = "UN",
            quantidadeEstoque = 500,
            valorUnitario = 23.45,
            marca = "Purina",
            imagens = listOf(Imagens("https://images.tcdn.com.br/img/img_prod/804492/cat_chow_filhotes_frango_e_leite_10_1kg_707_1_20200727151737.jpg"))
        ),
        isExpanded=false,
        amount = "100",
    )

    QuantityField(state, onQuantityChange = {})

}