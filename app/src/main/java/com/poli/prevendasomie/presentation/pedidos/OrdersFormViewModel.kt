package com.poli.prevendasomie.presentation.pedidos

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.poli.prevendasomie.core.UiEvent
import com.poli.prevendasomie.presentation.pedidos.clientselection.SelectionEvent
import com.poli.prevendasomie.presentation.pedidos.clientselection.SelectionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class OrdersFormViewModel
@Inject constructor() : ViewModel() {


    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()




}
