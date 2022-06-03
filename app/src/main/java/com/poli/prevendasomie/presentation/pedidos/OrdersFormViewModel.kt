package com.poli.prevendasomie.presentation.pedidos

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.domain.mappers.toClientModel
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.usecase.UseCases
import com.poli.prevendasomie.presentation.pedidos.clientselection.SelectableClientUiState
import com.poli.prevendasomie.presentation.pedidos.clientselection.SelectionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersFormViewModel
@Inject constructor(
    private val useCase: UseCases,

    private val savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private val _state = mutableStateOf(OrderOverviewState())
    val state = _state

    val key = mutableStateOf(false)

    var clientState by mutableStateOf(SelectionState())
    val selecionado = savedStateHandle.get<ClientesCadastro>("cliente")

    init {

        loadClientList()
    }

    fun onEvent(event: OrderOverviewEvent) {
        Log.d("SELECIONADO", "$selecionado")
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

            _state.value = state.value.copy(
                cliente = event.cliente
            )

            val x = savedStateHandle.set("cliente", event.cliente)

            Log.d("SAVED VM", "${savedStateHandle.get<ClientesCadastro>("cliente")}")

            // _uiEvent.send(UiEvent.NavigateUp)
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
