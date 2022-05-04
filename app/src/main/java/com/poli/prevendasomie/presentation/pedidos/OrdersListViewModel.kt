package com.poli.prevendasomie.presentation.pedidos

import androidx.lifecycle.ViewModel
import com.poli.prevendasomie.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrdersListViewModel @Inject constructor(
    useCase: UseCases
) : ViewModel() {

    val pedidos = useCase.getOrdersListUseCase()
}
