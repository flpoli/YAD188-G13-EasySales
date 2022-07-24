package com.poli.easysales.presentation.pedidos.productselection

import android.os.Parcelable
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro
import kotlinx.parcelize.Parcelize

@Parcelize
data class SelectableProductUiState(

    val produto: ProdutoServicoCadastro,
    val isSelected: Boolean = false,
    val isExpanded: Boolean = false,
    val amount: String = "",
    val price: String = ""
): Parcelable
