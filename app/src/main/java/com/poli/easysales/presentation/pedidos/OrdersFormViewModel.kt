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
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.usecase.UseCases
import com.poli.easysales.presentation.pedidos.clientselection.SelectableClientUiState
import com.poli.easysales.presentation.pedidos.clientselection.SelectionState
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
    var state = _state

    var clientState by mutableStateOf(SelectionState())

    init {

        loadClientList()
    }

    fun onEvent(event: OrderOverviewEvent) {
        when (event) {

            is OrderOverviewEvent.OnClientSelected -> {

                onClientSelected(event)
                Log.d("VM - Event", "$event")
            }
            is OrderOverviewEvent.OnProductSelected -> {
            }
        }
    }

    fun getClientData(): ClientesCadastro? {
        Log.d("VM - getClientData", "${savedStateHandle.get<ClientesCadastro>("cliente")}")
        return savedStateHandle["cliente"]
    }

    private fun onClientSelected(event: OrderOverviewEvent.OnClientSelected) {

        viewModelScope.launch {

            _state.value = state.value.copy(
                cliente = event.cliente
            )

            savedStateHandle["cliente"] = event.cliente

            Log.d("VM - onSelect", "${savedStateHandle.get<ClientesCadastro>("cliente")}")

            Log.d("VM - STATE", "$state")
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
