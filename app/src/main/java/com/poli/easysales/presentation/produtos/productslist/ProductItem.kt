package com.poli.easysales.presentation.produtos.productslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.poli.prevendasomie.R
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro
import com.poli.easysales.presentation.util.parseImageUrl
import com.poli.easysales.presentation.util.trimLeadingZeros
import com.poli.easysales.ui.theme.LocalSpacing

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProductListItem(
    onItemClick: () -> Unit,

    produto: ProdutoServicoCadastro,
    modifier: Modifier = Modifier
) {

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
            .clickable { onItemClick() }
            .padding(end = spacing.spaceMedium)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = rememberImagePainter(
                    data = produto.imagens?.firstOrNull()?.urlImagem?.let { parseImageUrl(it) },
                    builder = {
                        crossfade(false)
                        error(R.drawable.no_image_fallback)
                        fallback(R.drawable.no_image_fallback)
                    }
                ),
                contentDescription = produto.descricao,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp))
            )
            Spacer(modifier = Modifier.width(spacing.spaceMedium))
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Text(
                    text = stringResource(id = R.string.cod_prod, trimLeadingZeros(produto.codigo)),
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis

                )
                Text(
                    text = produto.descricao ?: "null?",
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = stringResource(id = R.string.quantidade, produto.quantidadeEstoque!!),
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
