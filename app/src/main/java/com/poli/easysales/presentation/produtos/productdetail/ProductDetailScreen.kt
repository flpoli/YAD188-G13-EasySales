package com.poli.easysales.presentation.produtos.productdetail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.poli.prevendasomie.R
import com.poli.easysales.presentation.produtos.components.InfoBox
import com.poli.easysales.presentation.produtos.components.MoreInfoBox
import com.poli.easysales.presentation.util.parseImageUrl
import com.poli.easysales.presentation.util.trimLeadingZeros

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProductDetailScreen(

    navController: NavHostController,
    viewModel: ProductDetailViewModel = hiltViewModel()

) {

    val selectedProduct by viewModel.selectedProduct.collectAsState()

    Column(

        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {

        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier

        ) {
            Image(
                painter = rememberImagePainter(
                    data = selectedProduct?.imagens?.firstOrNull()?.urlImagem?.let {
                        parseImageUrl(
                            it
                        )
                    },
                    builder = {
                        crossfade(true)
                        error(R.drawable.no_image_fallback)
                        fallback(R.drawable.no_image_fallback)
                    }
                ),
                contentDescription = selectedProduct?.descricao,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()

            )
        }

        Divider()

        Text(
            text = "Código",
            style = TextStyle(
                color = Color.Gray,
                textAlign = TextAlign.Left
            )
        )
        Text(
            text = trimLeadingZeros(selectedProduct?.codigo),
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                textAlign = TextAlign.Left
            )
        )

        Divider()

        Text(
            text = "Descrição:",
            style = TextStyle(
                color = Color.Gray,
                textAlign = TextAlign.Left
            )

        )
        Text(
            text = selectedProduct?.descricao ?: ""
        )

        Divider()

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
        ) {
            InfoBox(
                icon = Icons.Default.AttachMoney,
                iconColor = MaterialTheme.colors.primary,
                bigText = selectedProduct?.valorUnitario.toString(),
                smallText = "preço unitário",
                textColor = Color.Black
            )
            InfoBox(
                icon = Icons.Default.Inventory,
                iconColor = MaterialTheme.colors.primary,
                bigText = "${selectedProduct?.quantidadeEstoque}${selectedProduct?.unidade}",
                smallText = "estoque disponível",
                textColor = Color.Black
            )
        }

        Column() {

            val isVisible = remember { mutableStateOf(false) }

            val icon = if (isVisible.value) {
                Icons.Default.ArrowDropUp
            } else {
                Icons.Default.ArrowDropDown
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {

                    isVisible.value = !isVisible.value
                }
            ) {
                Text(
                    text = "Outras informações"
                )

                Icon(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(32.dp),
                    imageVector = icon,
                    contentDescription = "Info Icon",
                    tint = Color.Gray
                )
            }

            Column() {
                AnimatedVisibility(visible = isVisible.value) {

                    MoreInfoBox(
                        selectedProduct = selectedProduct!!
                    )
                }
            }
        }
    }
}
