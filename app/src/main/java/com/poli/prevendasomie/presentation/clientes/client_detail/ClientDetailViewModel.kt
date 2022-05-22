package com.poli.prevendasomie.presentation.clientes.client_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.domain.model.clientes.ClientesCadastro
import com.poli.prevendasomie.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientDetailViewModel @Inject constructor(
    private val useCase: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ClientDetailState())
    val state: State<ClientDetailState> = _state

    private val _selectClient: MutableStateFlow<ClientesCadastro?> = MutableStateFlow(null)
    val selectedClient: StateFlow<ClientesCadastro?> = _selectClient

    init {
        viewModelScope.launch(Dispatchers.IO) {

            val clientId = savedStateHandle.get<Long>("clientId")
            Log.d("VAL clientId", "$clientId")
            _selectClient.value = clientId?.let {
                useCase.getSelectedClientUseCase(clientId = clientId)
            }
        }
    }
}
