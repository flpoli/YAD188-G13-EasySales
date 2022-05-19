package com.poli.prevendasomie.presentation.pedidos.clientselection

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.core.UiText
import com.poli.prevendasomie.domain.mappers.toClientModel
import com.poli.prevendasomie.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientSelectionViewModel
@Inject constructor(private val useCase: UseCases) : ViewModel() {

    init{
        loadClientList()
    }

    var state by mutableStateOf(SelectionState())

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: SelectionEvent) {

        when (event) {

            is SelectionEvent.OnClientSelected -> {

                selectClient(event)
            }
        }
    }


    private fun selectClient(event: SelectionEvent.OnClientSelected){


        viewModelScope.launch {

            val uiState = state.selectableClient.find { it.cliente == event.cliente }


            useCase.insertSelectedClientUseCase(

                selectedClient = uiState?.cliente ?: return@launch
            )


            _uiEvent.send(UiEvent.NavigateUp)
        }



    }

    private fun loadClientList(){

        viewModelScope.launch {

            state = state.copy(
                isLoading = true,
                selectableClient = emptyList()
            )

            useCase.getClientListForSelectionUseCase()
                .onSuccess {
                    clientes ->

                        state = state.copy(
                            isLoading = true,
                            selectableClient = clientes.map {
                                SelectableClientUiState(it.toClientModel())
                            }
                        )
                }
                .onFailure {
                    state = state.copy(isLoading = false)
                    _uiEvent.send(
                        UiEvent.ShowSnackbar(
                            UiText.StringText("ERRINHo")
                        )
                    )
                }


        }


    }

}



