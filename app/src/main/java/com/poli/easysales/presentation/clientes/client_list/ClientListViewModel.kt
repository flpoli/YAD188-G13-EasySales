package com.poli.easysales.presentation.clientes.client_list

import androidx.lifecycle.ViewModel
import androidx.paging.map
import com.poli.easysales.domain.mappers.toClientModel
import com.poli.easysales.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ClientListViewModel
@Inject constructor(useCase: UseCases) : ViewModel() {

    val clientes = useCase.getClientListUseCase().map { it ->

        it.map {

            it.toClientModel()
        }
    }
}
