package com.poli.prevendasomie.presentation.clientes.client_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.prevendasomie.common.Env.APP_KEY
import com.poli.prevendasomie.common.Env.APP_SECRET
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.repository.ClientsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientDetailViewModel @Inject constructor(

    private val repository: ClientsRepository

) : ViewModel() {

    private val _state = mutableStateOf(ClientDetailState())
    val state: State<ClientDetailState> = _state

    fun loadClientByCode(codCliOmie: String) {

        viewModelScope.launch {

            val result = repository.getClientByCode(
                Request.ClientByCodeRequest(
                    "ConsultarCliente",
                    APP_KEY,
                    APP_SECRET,
                    listOf(Param.ParamConsultarCliente(codCliOmie))

                )
            )

            when (result) {

                is Resource.Success -> {
                    _state.value = ClientDetailState(client = result.data)

                }
                else -> {}
            }
        }




    }

}