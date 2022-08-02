package com.poli.easysales.presentation.pedidos

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowCircleDown
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropDownCircle
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.poli.easysales.core.UiEvent
import com.poli.easysales.data.remote.dto.produtos.Imagens
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.navigation.Screen
import com.poli.easysales.presentation.components.AppScaffold
import com.poli.easysales.presentation.components.DatePicker
import com.poli.easysales.presentation.components.EndOfScreen
import com.poli.easysales.presentation.components.PrimaryButton
import com.poli.easysales.presentation.components.ProductImage
import com.poli.easysales.presentation.pedidos.productselection.SelectableProductUiState
import com.poli.easysales.ui.theme.secondaryDarkColor
import kotlinx.coroutines.CoroutineScope
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
@ExperimentalCoilApi
fun OrdersFormScreen(
    savedStateHandle: SavedStateHandle?,
    scaffoldState: ScaffoldState,
    preferences: Preferences,
    scope: CoroutineScope,
    navController: NavHostController,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: OrdersFormViewModel = hiltViewModel(),
) {

    val context = LocalContext.current

    val state = remember {
        viewModel.state
    }

    LaunchedEffect(key1 = true) {

        viewModel.uiEvent.collect {

                event ->
            when (event) {

                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }

    AppScaffold(
        scaffoldState = scaffoldState,
        navController = navController,
        scope = scope,
        preferences = preferences,
        showFab = false,
        showBottomBar = false

    ) {

        Column(
            modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            HeaderSection(viewModel, context)

            Column( modifier = Modifier
                .fillMaxSize()
                .weight(1f)){

                Row(
//                    verticalAlignment = Alignment.,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    ClientBox(
                        cliente = state.cliente,
                        onClick = { onNavigate(UiEvent.Navigate(Screen.ClientSelectionScreen.route)) }
                    )

                }

                Spacer(modifier = Modifier.height(12.dp))

                ProductBox(
                    produtos = state.produtos,
                    onClick = {

                        onNavigate(UiEvent.Navigate(Screen.ProductSelectionScreen.route))
                    }
                )

            }
            DatePaymentSection(viewModel, context)


            CheckoutSection(
                produtos = state.produtos,
                viewModel = viewModel,
                modifier = Modifier.weight(.2f)

            )
        }


        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
fun ClientBox(
    cliente: ClientesCadastro?,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
//            .clickable {}
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)


        ){
            Text(
                text = "Cliente",
                fontSize = 24.sp,
                textAlign = TextAlign.Left
            )

            IconButton(onClick = { onClick() }) {
                Icon(
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .size(32.dp),
                    imageVector = Icons.Default.Add,
                    contentDescription = "add Icon",
                    tint = Color.Gray
                )

            }
        }


        if (cliente != null) {
            ClientItem(cliente = cliente)
        }
    }
}

@Composable
fun ClientItem(
    cliente: ClientesCadastro
) {

    Text(text = cliente.nomeFantasia ?: "")
}

@Composable
@ExperimentalCoilApi
fun ProductBox(
    produtos: List<SelectableProductUiState>?,
    onClick: () -> Unit
) {

    var isVisible by remember {
        mutableStateOf(true)
    }
    val icon = if (isVisible) {
        Icons.Default.ArrowCircleDown
    } else {
        Icons.Default.ArrowCircleUp
    }
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .clickable {
                isVisible = !isVisible
            }
        ){
            Text(
                text = "Produtos",
                fontSize = 24.sp,
                textAlign = TextAlign.Left

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


        Spacer(Modifier.height(16.dp))

        AnimatedVisibility(visible = isVisible ) {


            LazyColumn(
                contentPadding = PaddingValues(all = 24.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {

                if (produtos != null)
                    items(
                        items = produtos,

                        ) { produto ->
                        ProductItem(produto)
                    }
            }
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClick()
                }
        ) {

            Text(text = "+ Adicionar produto")
        }

    }

}

@Composable
fun HeaderSection(viewModel: OrdersFormViewModel, context: Context){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = secondaryDarkColor)
    ){

        Text(
            text = "Pedido N° XXX",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier.padding(12.dp)
            )

        DatePicker(
            modifier = Modifier
                .width(170.dp)
                .padding(12.dp)
                .clickable { viewModel.showDatePickerDialog(context) },
            isEnabled = true,
            value = viewModel.previsaoFaturamento,
            label = "Previsão",
            placeHolder = "Data Previsão",
            onValueChange = { viewModel.previsaoFaturamento = it }

        )
    }

}
@Composable
fun DatePaymentSection(viewModel: OrdersFormViewModel, context: Context){


}

@ExperimentalCoilApi
@Composable
fun ProductItem(
    produto: SelectableProductUiState
) {

    Column {

        Row {

            ProductImage(produto = produto.produto)

            Column {

                Text(
                    text = produto.produto.descricao.orEmpty()
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Quantidade: ${produto.amount} ${produto.produto.unidade}"
                    )
                    Text(
                        text = " - "
                    )
                    Text(
                        text = "R$${produto.produto.valorUnitario}"
                    )
                }

                Text(
                    text = "SKU: ${produto.produto.codigoProduto}"
                )
            }

            Box(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        shape = RoundedCornerShape(5.dp),
                        brush = SolidColor(Color.Black)
                    )
            ) {
            }
        }

        EndOfScreen(4.dp)

        Divider(
            thickness = 2.dp,
            color = Color.LightGray
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewScreen() {
}

@Composable
fun CheckoutSection(
    produtos: List<SelectableProductUiState>,
    viewModel: OrdersFormViewModel,
    modifier: Modifier
) {

    fun calcOrderTotal(): String {
        val total = produtos.sumOf {
            (it.amount.toDouble() * it.produto.valorUnitario!!)
        }

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN

        return df.format(total)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(color = secondaryDarkColor)
    ){
        Text(
            text = "Total: ${calcOrderTotal()}",
            fontSize = 32.sp,
            color = Color.White,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(.6f)

        )

        PrimaryButton(
            text = "Enviar",
            onClick = {

                viewModel.onEvent(OrderOverviewEvent.OnSubmitOrder)
            },
            modifier = Modifier
                .fillMaxWidth(.9f)
                .padding(12.dp)


        )
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewTotalSection() {

//    TotalSection()
}

@Composable
@Preview(showBackground = true)
fun PreviewClientBox() {

    val cliente = ClientesCadastro(
        nomeFantasia = "Cerealista Pirituba"
    )

//    ClientBox(state = cliente, onClick ={ })
}

@ExperimentalCoilApi
@Composable
@Preview(showBackground = true)
fun PreviewProductItem() {

    val produto = ProdutoServicoCadastro(
        codigo = "123456",
        codigoProduto = 12345678,
        descricao = "Ração CatChow Frango",
        descrDetalhada = "Ração catchow frango 1kg",
        unidade = "UN",
        quantidadeEstoque = 500,
        valorUnitario = 23.45,
        marca = "Purina",
        imagens = listOf(Imagens("https://images.tcdn.com.br/img/img_prod/804492/cat_chow_filhotes_frango_e_leite_10_1kg_707_1_20200727151737.jpg"))
    )

//    ProductItem(produto = produto)
}

@Composable
@ExperimentalCoilApi
@Preview(showBackground = true)
fun PreviewProductBox() {

    val produtos = mutableListOf(

        ProdutoServicoCadastro(
            codigo = "123456",
            codigoProduto = 12345678,
            descricao = "Ração CatChow Frango",
            descrDetalhada = "Ração catchow frango 1kg",
            unidade = "UN",
            quantidadeEstoque = 500,
            valorUnitario = 23.45,
            marca = "Purina",
            imagens = listOf(
                Imagens("https://images.tcdn.com.br/img/img_prod/804492/cat_chow_filhotes_frango_e_leite_10_1kg_707_1_20200727151737.jpg")
            )
        ),
        ProdutoServicoCadastro(
            codigo = "123456",
            codigoProduto = 12345678,
            descricao = "Ração CatChow Frango",
            descrDetalhada = "Ração catchow frango 1kg",
            unidade = "UN",
            quantidadeEstoque = 500,
            valorUnitario = 23.45,
            marca = "Purina",
            imagens = listOf(Imagens("https://images.tcdn.com.br/img/img_prod/804492/cat_chow_filhotes_frango_e_leite_10_1kg_707_1_20200727151737.jpg"))
        )
    )

//    ProductBox(state = produtos, onClick = {} )
}
