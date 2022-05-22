package com.poli.prevendasomie.presentation.clientes.client_list

import androidx.lifecycle.ViewModel
import androidx.paging.map
import com.poli.prevendasomie.domain.mappers.toClientModel
import com.poli.prevendasomie.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ClientListViewModel
@Inject constructor(private val useCase: UseCases) : ViewModel() {

    val clientes = useCase.getClientListUseCase().map { it ->

        it.map {

            it.toClientModel()
        }
    }
}
