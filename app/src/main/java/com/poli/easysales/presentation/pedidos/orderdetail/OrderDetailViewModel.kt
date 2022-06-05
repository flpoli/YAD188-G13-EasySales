package com.poli.easysales.presentation.pedidos.orderdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poli.easysales.domain.model.pedidos.PedidoVendaProduto
import com.poli.easysales.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderDetailViewModel @Inject constructor(

    private val useCase: UseCases,
    savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val _selectedOrder: MutableStateFlow<PedidoVendaProduto?> = MutableStateFlow(null)
    val selectedOrder: StateFlow<PedidoVendaProduto?> = _selectedOrder

    init {

        viewModelScope.launch {

            val orderId = savedStateHandle.get<Long>("orderId")

            _selectedOrder.value = orderId?.let {

                useCase.getOrderDetail(orderId = orderId)
            }
        }
    }
}
