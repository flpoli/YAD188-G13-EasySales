package com.poli.prevendasomie.presentation.client_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.domain.use_case.GetClientsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ClientListViewModel @Inject constructor(getClientsUseCase: GetClientsUseCase): ViewModel(){

    private val _state = mutableStateOf(ClientListState())
    val state: State<ClientListState> = _state

    init {
        getClients()
    }

    private fun getClients(){

        getClientsUseCase().onEach { result ->
            when(result){
                is Resource.Success<*> -> {
                    _state.value = ClientListState(clients = result.data ?: emptyList())
                }
                is Resource.Error<*> -> {
                    _state.value = ClientListState(error = result.message ?: "An unexpected error ocurred")
                }
                is Resource.Loading<*> -> {
                    _state.value = ClientListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}