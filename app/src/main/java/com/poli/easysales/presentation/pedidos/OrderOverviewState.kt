package com.poli.easysales.presentation.pedidos

import android.os.Parcelable
import com.poli.easysales.domain.model.clientes.ClientesCadastro
import com.poli.easysales.presentation.pedidos.productselection.SelectableProductUiState
import kotlinx.parcelize.Parcelize

@Parcelize
data class OrderOverviewState(

    val cliente: ClientesCadastro = ClientesCadastro(),
    val produtos: List<SelectableProductUiState> = emptyList()

) : Parcelable
