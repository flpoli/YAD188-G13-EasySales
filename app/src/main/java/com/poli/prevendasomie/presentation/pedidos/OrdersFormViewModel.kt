package com.poli.prevendasomie.presentation.pedidos

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrdersFormViewModel
@Inject constructor(): ViewModel() {


    fun onAddClientClicked(

    ) {
        Log.d("ORDERSCREEN", "ADICIONAR CLIENTE EM PEDIDO")
    }
}