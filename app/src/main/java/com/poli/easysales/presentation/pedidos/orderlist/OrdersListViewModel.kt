package com.poli.easysales.presentation.pedidos.orderlist

import androidx.lifecycle.ViewModel
import androidx.paging.map
import com.poli.easysales.domain.mappers.toPedidoModel
import com.poli.easysales.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class OrdersListViewModel @Inject constructor(
    useCase: UseCases
) : ViewModel() {

    val pedidos = useCase.getOrdersListUseCase().map { it ->

        it.map {

            it.toPedidoModel()
        }
    }
}
