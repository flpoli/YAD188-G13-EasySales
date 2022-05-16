package com.poli.prevendasomie.presentation.pedidos.searchclient

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.domain.usecase.UseCases
import com.poli.prevendasomie.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientSelectionViewModel
    @Inject constructor(
        private val useCase: UseCases
    ): ViewModel() {

        var state by mutableStateOf(SelectableClientUiState())
            private set

        var searchState by mutableStateOf(SearchState())
            private set

        private val _uiEvent = Channel<UiEvent>()
        val uiEvent = _uiEvent.receiveAsFlow()

        val clientes = useCase.getClientListUseCase()


    fun onEvent(event: SearchEvent){

        when(event) {

            is SearchEvent.OnSearch -> {

            }

            is SearchEvent.OnSelectClient -> {
                viewModelScope.launch {
                    val uiState = searchState.selectableClient.find {
                        it.codClienteOmie == event.cliente.codClienteOmie
                    }



                    _uiEvent.send(UiEvent.NavigateUp)

                }
            }
        }

    }

}