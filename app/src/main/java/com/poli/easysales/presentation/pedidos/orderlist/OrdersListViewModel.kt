package com.poli.easysales.presentation.pedidos.orderlist

import androidx.lifecycle.ViewModel
import com.poli.easysales.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrdersListViewModel @Inject constructor(
    useCase: UseCases
) : ViewModel() {

    val pedidos = useCase.getOrdersListUseCase()
}
