package com.poli.prevendasomie.presentation.pedidos

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.domain.mappers.toClientModel
import com.poli.prevendasomie.domain.usecase.UseCases
import com.poli.prevendasomie.presentation.pedidos.clientselection.SelectableClientUiState
import com.poli.prevendasomie.presentation.pedidos.clientselection.SelectionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersFormViewModel
@Inject constructor(private val useCase: UseCases) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private val _state = MutableStateFlow(OrderOverviewState())
    val state: StateFlow<OrderOverviewState> = _state

    var clientState by mutableStateOf(SelectionState())

    init {
        loadClientList()
    }
    fun onEvent(event: OrderOverviewEvent) {

        when (event) {

            is OrderOverviewEvent.OnClientSelected -> {

                onClientSelected(event)
            }
            is OrderOverviewEvent.OnProductSelected -> {
            }
        }
    }

    private fun onClientSelected(event: OrderOverviewEvent.OnClientSelected) {

        viewModelScope.launch {

            _state.emit(

                state.value.copy(
                    cliente = event.cliente
                )
            )

//            _state.value = state.value.copy(
//                cliente = event.cliente
//            )

//            state.value = state.value.copy(
//                cliente = event.cliente,
//                produtos = emptyList()
//            )
            Log.d("_STATE VM", "${_state.value}")
            Log.d("STATE VM", "${state.value}")
            _uiEvent.send(UiEvent.NavigateUp)
        }
    }

    private fun loadClientList() {
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
