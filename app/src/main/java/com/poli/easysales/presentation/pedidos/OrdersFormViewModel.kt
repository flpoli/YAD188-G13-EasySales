package com.poli.easysales.presentation.pedidos

import android.app.DatePickerDialog
import android.content.Context
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.easysales.common.Constants.DEFAULT_DF
import com.poli.easysales.core.UiEvent
import com.poli.easysales.data.remote.dto.pedidos.Ide
import com.poli.easysales.domain.model.pedidos.Cabecalho
import com.poli.easysales.domain.model.pedidos.Det
import com.poli.easysales.domain.model.pedidos.InformacoesAdicionais
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.model.pedidos.Produto
import com.poli.easysales.domain.usecase.UseCases
import com.poli.easysales.presentation.util.genCodOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class OrdersFormViewModel
@Inject constructor(
    private val useCase: UseCases,

) : ViewModel() {

    var previsaoFaturamento by mutableStateOf("")
    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var state by mutableStateOf(OrderOverviewState())
        private set

    val cliente = state.cliente

    fun onEvent(event: OrderOverviewEvent) {
        when (event) {

            is OrderOverviewEvent.OnClientSelected -> {

                onClientSelected(event)
            }
            is OrderOverviewEvent.OnProductSelected -> {

                onProductSelected(event)
            }
            is OrderOverviewEvent.OnSubmitOrder -> {

                CoroutineScope(Dispatchers.Main).launch {
                    onSubmitOrder()
                }
            }
            else -> {}
        }
    }

    private fun onClientSelected(event: OrderOverviewEvent.OnClientSelected) {

        viewModelScope.launch {

            state = state.copy(
                cliente = event.cliente
            )

            _uiEvent.send(UiEvent.NavigateUp)
        }
    }

    private fun onProductSelected(event: OrderOverviewEvent.OnProductSelected) {

        state = state.copy(
            produtos = event.produtos
        )
    }

    private suspend fun onSubmitOrder() {

        val order = listOf(
            PedidoVendaProduto(

                cabecalho = Cabecalho(
                    codigoPedido = genCodOrder().codigoPedido,
                    codigoPedidoIntegracao = genCodOrder().codigoPedidoIntegracao,
                    codigoCliente = state.cliente.codClienteOmie,
                    importadoApi = "S",
                    dataPrevisao = previsaoFaturamento,
                    origemPedido = "API"

                ),
                det = state.produtos.map {
                    Det(
                        ide = Ide(
                            codigoItemIntegracao = it.produto.codigoProduto.toString() // (Obrigatório)
                        ),
                        produto = Produto(
                            codigo = it.produto.codigo,
                            codigoProduto = it.produto.codigoProduto,
                            quantidade = it.amount.toInt(),
                            valorUnitario = it.produto.valorUnitario

                        )
                    )
                },
                informacoesAdicionais = InformacoesAdicionais(
                    consumidorFinal = "S",
                    codigoCategoria = "1.01.99", // (Obrigatório) tratar em tela posteriormente
                    codigoContaCorrente = 631821336 // (Obrigatório) tratar em tela posteriormente
                )
            )
        )

        useCase.createNewOrderUsecase(order)
    }

    fun showDatePickerDialog(context: Context) {

        val calendar = getCalendar()

        DatePickerDialog(
            context,
            { _, year, month, day -> previsaoFaturamento = getDateAsString(year, month, day) },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)

        ).show()
    }

    private fun getDateAsString(day: Int, month: Int, year: Int): String {
        val calendar = getCalendar()
        val dateFormat = SimpleDateFormat(DEFAULT_DF)
        return dateFormat.format(calendar.time)
    }

    private fun getCalendar(): Calendar {
        return if (previsaoFaturamento.isEmpty())
            Calendar.getInstance()
        else
            getLastPickedDateCalendar()
    }

    private fun getLastPickedDateCalendar(): Calendar {
        val dateFormat = SimpleDateFormat(DEFAULT_DF)
        val calendar = Calendar.getInstance()
        calendar.time = dateFormat.parse(previsaoFaturamento)
        return calendar
    }
}
