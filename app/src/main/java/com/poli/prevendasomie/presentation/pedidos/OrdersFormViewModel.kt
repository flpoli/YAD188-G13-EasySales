package com.poli.prevendasomie.presentation.pedidos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.poli.prevendasomie.core.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class OrdersFormViewModel
@Inject constructor() : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var state by mutableStateOf(OrderOverviewState())

    fun onEvent(event: OrderOverviewEvent) {

        when (event) {

            is OrderOverviewEvent.OnClientSelected -> {
            }
        }
    }

    private fun onSelected() {
    }
}
