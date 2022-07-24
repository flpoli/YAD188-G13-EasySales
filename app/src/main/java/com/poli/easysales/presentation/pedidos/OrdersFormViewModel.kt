package com.poli.easysales.presentation.pedidos

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.easysales.core.UiEvent
import com.poli.easysales.domain.mappers.toClientModel
import com.poli.easysales.domain.model.pedidos.Cabecalho
import com.poli.easysales.domain.model.pedidos.Det
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.model.pedidos.Produto
import com.poli.easysales.domain.usecase.UseCases
import com.poli.easysales.domain.usecase.pedidos.CreateNewOrderUseCaseImpl
import com.poli.easysales.presentation.pedidos.clientselection.SelectableClientUiState
import com.poli.easysales.presentation.pedidos.clientselection.SelectionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersFormViewModel
@Inject constructor(
    private val useCase: UseCases,
    private val newOrderUseCase: CreateNewOrderUseCaseImpl,
    savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

     var state by mutableStateOf(OrderOverviewState())
        private set

    val cliente = state.cliente

    var clientState by mutableStateOf(SelectionState())



    fun onEvent(event: OrderOverviewEvent) {
        when (event) {

            is OrderOverviewEvent.OnClientSelected -> {

                onClientSelected(event)
            }
            is OrderOverviewEvent.OnProductSelected -> {

                onProductSelected(event)
            }
            is OrderOverviewEvent.OnSubmitOrder -> {

                onSubmitOrder()

            }
        }
    }

    private fun onClientSelected(event: OrderOverviewEvent.OnClientSelected) {


            state = state.copy(
                cliente = event.cliente
            )

            Log.d("VM - CLIENTE","${state}" )


    }


    private fun onProductSelected(event: OrderOverviewEvent.OnProductSelected) {

        state = state.copy(
            produtos = event.produtos
        )

        Log.d("VM - produtos", "${state}")

        }

    private fun onSubmitOrder() {


        Log.d("OnSubmitOrder", "${state}")
        viewModelScope.launch {


            val det = state.produtos.map {

                     Det(
                        produto = Produto(
                            codigo = it.produto.codigo,
                            codigoProduto = it.produto.codigoProduto,
                            quantidade = it.amount.toInt(),
                            valorUnitario = it.produto.valorUnitario

                        )
                    )
                }

            val order = PedidoVendaProduto(
                id = 1,
                cabecalho = Cabecalho(
                    codigoCliente = state.cliente.codClienteOmie
                ),
                det = det
            )

            newOrderUseCase(order)
        }
    }



    fun loadClientList() {
        viewModelScope.launch {

            useCase.getClientListForSelectionUseCase().collect { it ->

                clientState = clientState.copy(
                    isLoading = false,
                    selectableClient = it.map { SelectableClientUiState(it.toClientModel()) }
                )
            }
        }
    }
}





