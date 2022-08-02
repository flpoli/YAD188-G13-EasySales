package com.poli.easysales.presentation.clientes.client_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.map
import com.poli.easysales.core.UiEvent
import com.poli.easysales.core.UiText
import com.poli.easysales.core.getString
import com.poli.easysales.domain.mappers.toClientModel
import com.poli.easysales.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientListViewModel
@Inject constructor(private val useCase: UseCases) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    val clientes = useCase.getClientListUseCase().map { it ->

        it.map {

            it.toClientModel()
        }
    }

    fun onSwipeToDelete(codCli: Long) {

        viewModelScope.launch {

            val deleteCliente = useCase.deleteClientByCode(codCli)

            _uiEvent.send(UiEvent.ShowSnackbar(UiText.StringText(deleteCliente.data?.descricaoStatus ?: "Não foi possível excluir")))

        }


    }
}
