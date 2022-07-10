package com.poli.easysales.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro
import com.poli.easysales.presentation.util.parseImageUrl
import com.poli.prevendasomie.R

@ExperimentalCoilApi
@Composable
fun ProductImage(
    produto: ProdutoServicoCadastro
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
}
