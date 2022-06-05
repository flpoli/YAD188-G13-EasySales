package com.poli.easysales.presentation.clientes.client_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.domain.usecase.UseCases
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

    private val _selectClient: MutableStateFlow<ClientesCadastro?> = MutableStateFlow(null)
    val selectedClient: StateFlow<ClientesCadastro?> = _selectClient

    init {
        viewModelScope.launch(Dispatchers.IO) {

            val clientId = savedStateHandle.get<Long>("clientId")
            _selectClient.value = clientId?.let {
                useCase.getSelectedClientUseCase(clientId = clientId)
            }
        }
    }
}
