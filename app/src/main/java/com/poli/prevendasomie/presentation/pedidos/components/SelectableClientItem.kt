package com.poli.prevendasomie.presentation.pedidos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.poli.prevendasomie.presentation.pedidos.searchclient.SelectableClientUiState
import com.poli.prevendasomie.ui.theme.LocalSpacing

@Composable
fun SelectableClientItem(

    selectableClientUiState: SelectableClientUiState,
    onClick: () -> Unit,
    onSelectClient: () ->  Unit,
    modifier: Modifier = Modifier
){

    val cliente = selectableClientUiState.cliente
    val spacing = LocalSpacing.current

    Column(

        modifier= modifier
            .clip(RoundedCornerShape(5.dp))
            .padding(spacing.spaceExtraSmall)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(5.dp)
            )
            .background(MaterialTheme.colors.primarySurface)
            .clickable { onClick() }
            .padding(spacing.spaceMedium)
    ){

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

            Row(
                modifier = Modifier.weight(1f)

            ){
                Column(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ){

                    Text(
                        text = cliente?.nomeFantasia ?: "NÃO DEFINIDO",
                        style = MaterialTheme.typography.body1,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

    }

}