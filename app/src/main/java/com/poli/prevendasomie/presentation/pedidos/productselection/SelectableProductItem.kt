package com.poli.prevendasomie.presentation.pedidos.productselection

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.unit.dp
import com.poli.prevendasomie.ui.theme.LocalSpacing

@Composable
fun SelectableProductItem(

    selectableProductUiState: SelectableProductUiState,
    onClick: () -> Unit,
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
                ){

                    IconButton(
                        onClick = {}
                    ){
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = "",
                            tint = Color.Red
                        )
                    }

                    BasicTextField(

                        value = selectableProductUiState.amount,
                        onValueChange = {},
                        singleLine = true,
                        modifier = Modifier
                            .width(16.dp)
                            .border(
                                shape = RoundedCornerShape(5.dp),
                                width = 0.5.dp,
                                color = MaterialTheme.colors.onSurface
                            )

                    )


                    IconButton(
                        onClick = {}
                    ){
                        Icon(
                            imageVector = Icons.Default.Add,
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
