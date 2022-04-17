package com.poli.prevendasomie.presentation.clientes.client_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.domain.use_case.clients.GetClientDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientDetailViewModel @Inject constructor(
    private val useCase: GetClientDetailsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ClientDetailState())
    val state: State<ClientDetailState> = _state

    fun loadClientByCode(codCliOmie: String) {

        viewModelScope.launch {

            useCase(codCliOmie).onEach { result ->
                when (result) {

                    is Resource.Success -> {
                        _state.value = ClientDetailState(client = result.data)
                    }
                    else -> {}
                }
            }
        }
    }
}
