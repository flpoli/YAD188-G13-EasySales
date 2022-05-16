package com.poli.prevendasomie.presentation.pedidos.searchclient

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject


@HiltViewModel
class SearchClientViewModel @Inject constructor(

    useCases: UseCases

): ViewModel() {

    var state by mutableStateOf(SearchState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: SearchEvent){

        when(event) {

            is SearchEvent.OnQueryChange -> {

                state = state.copy(query = event.query)
            }
            is SearchEvent.OnSearch -> {}
            is SearchEvent.OnToggleSelectableClient -> {}
            is SearchEvent.OnSelectClient -> {}


        }

    }

}