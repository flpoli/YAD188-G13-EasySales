package com.poli.easysales.presentation.pedidos

import android.app.DatePickerDialog
import android.util.Log
import android.widget.DatePicker
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.asLiveData
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.poli.easysales.core.UiEvent
import com.poli.easysales.data.remote.dto.produtos.Imagens
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.navigation.Screen
import com.poli.easysales.presentation.components.AppScaffold
import com.poli.easysales.presentation.components.EndOfScreen
import com.poli.easysales.presentation.components.PrimaryButton
import com.poli.easysales.presentation.components.ProductImage
import com.poli.easysales.presentation.pedidos.productselection.ProductSelectionEvent
import com.poli.easysales.presentation.pedidos.productselection.SelectableProductUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*
import kotlin.math.roundToInt
import kotlin.math.ulp

@Composable
fun OrdersFormScreen(
    savedStateHandle: SavedStateHandle?,
    scaffoldState: ScaffoldState,
    preferences: Preferences,
    scope: CoroutineScope,
    navController: NavHostController,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: OrdersFormViewModel = hiltViewModel(),
) {


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
//    DisposableEffect(key1 = true) {
//
//    }

    AppScaffold(
        scaffoldState = scaffoldState,
        navController = navController,
        scope = scope,
        preferences = preferences,
        showFab = false

    ) {



        Column {

            Spacer(modifier = Modifier.height(12.dp))

            ClientBox(
                cliente = state.cliente,
                onClick = { onNavigate(UiEvent.Navigate(Screen.ClientSelectionScreen.route)) }
            )

            Spacer(modifier = Modifier.height(12.dp))

            ProductBox(
                produtos = state.produtos,
                onClick = {

                    onNavigate(UiEvent.Navigate(Screen.ProductSelectionScreen.route))

                }
            )
//            viewModel.onEvent(OrderOverviewEvent.OnProductSelected(selectedProducts))

            PrimaryButton(
                text = "Enviar pedido",
                onClick = {


                        viewModel.onEvent(OrderOverviewEvent.OnSubmitOrder)


                }

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
            .clickable {

                onClick()
            }
    ) {

        Text(
            text = "Cliente",
            fontSize = 32.sp,
            textAlign = TextAlign.Left
        )

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


@OptIn(ExperimentalCoilApi::class)
@Composable
fun ProductBox(
    produtos: List<SelectableProductUiState>?,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()

    ) {



        Text(
            text = "Produtos",
            fontSize = 32.sp,
            textAlign = TextAlign.Left

        )
        Spacer(Modifier.height(16.dp))


        LazyColumn(
            contentPadding = PaddingValues(all = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ){

            if(produtos != null)
            items(
                items = produtos,

            )  {
                produto -> ProductItem(produto)
            }
            }

        if (produtos != null) {
            TotalSection(produtos)
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClick()
                }
        ){

            Text(text = "+ Adicionar produto")

        }
    }
}

@ExperimentalCoilApi
@Composable
fun ProductItem(
    produto: SelectableProductUiState
) {

    Column {


        Row {

            ProductImage(produto = produto.produto)

            Column() {

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
fun DateSection(){
    val mContext = LocalContext.current

    // Declaring integer values
    // for year, month and day
    val mYear: Int
    val mMonth: Int
    val mDay: Int

    // Initializing a Calendar
    val mCalendar = Calendar.getInstance()

    // Fetching current year, month and day
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    // Declaring a string value to
    // store date in string format
    val mDate = remember { mutableStateOf("") }

    // Declaring DatePickerDialog and setting
    // initial values as current values (present year, month and day)
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
        }, mYear, mMonth, mDay
    )

    Column() {

        // Creating a button that on
        // click displays/shows the DatePickerDialog
        Button(
            onClick = { mDatePickerDialog.show() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))
        ) {
            Text(text = "Open Date Picker", color = Color.White)
        }

        // Adding a space of 100dp height
        Spacer(modifier = Modifier.size(10.dp))

        // Displaying the mDate value in the Text
        Text(text = "Selected Date: ${mDate.value}", fontSize = 30.sp, textAlign = TextAlign.Center)
    }
}

@Composable
fun TotalSection(produtos: List<SelectableProductUiState>){


    fun calcOrderTotal(): String {
        val total =  produtos.sumOf {
            (it.amount.toDouble() * it.produto.valorUnitario!!)
        }

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN

        return df.format(total)
    }

    Text(text = "Total: ${calcOrderTotal()}")

}


@Composable
@Preview(showBackground = true)
fun previewTotalSection(){

//    TotalSection()

}

@Composable
@Preview(showBackground = true)
fun PreviewClientBox(){

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
            Imagens("https://images.tcdn.com.br/img/img_prod/804492/cat_chow_filhotes_frango_e_leite_10_1kg_707_1_20200727151737.jpg"))
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
