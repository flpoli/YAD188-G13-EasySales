package com.poli.prevendasomie.presentation.pedidos

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersFormViewModel
@Inject constructor() : ViewModel() {

    var state by mutableStateOf(OrderOverviewState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()


    fun onEvent(event: OrderOverviewEvent) {

        when(event) {

            is OrderOverviewEvent.OnClientSelected -> {

                state = state.copy(
                    cliente = state.cliente
                )
            }

        }

    }
}
