package com.poli.easysales.presentation.clientes.client_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.poli.easysales.domain.model.clientes.Tag

@Composable
fun ClientTagChip(
    tag: Tag
) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 2.dp,
                horizontal = 4.dp
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(50)
            )
            .clip(RoundedCornerShape(50))
            .padding(6.dp)
    ) {

        Text(text = tag.tag)
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewTag() {

    ClientTagChip(Tag("Fornecedor"))
}
