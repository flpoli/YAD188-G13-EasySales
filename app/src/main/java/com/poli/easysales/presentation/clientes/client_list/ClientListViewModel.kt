package com.poli.easysales.presentation.clientes.client_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.map
import com.poli.easysales.domain.mappers.toClientModel
import com.poli.easysales.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClientListViewModel
@Inject constructor(private val useCase: UseCases) : ViewModel() {

    val clientes = useCase.getClientListUseCase().map { it ->

        it.map {

            it.toClientModel()
        }
    }

    fun onSwipeToDelete(codCli: Long) {

        viewModelScope.launch {
            Log.d("EXECUTOU ON DELETE", "${codCli}")

            useCase.deleteClientByCode(codCli)
        }

    }
}
