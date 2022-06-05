package com.poli.easysales.presentation.produtos.productslist

import androidx.lifecycle.ViewModel
import androidx.paging.map
import com.poli.easysales.domain.mappers.toProdutoModel
import com.poli.easysales.domain.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val useCase: UseCases
) : ViewModel() {

    val produtos = useCase.getProductListUseCase()?.map { it ->

        it.map {
            it.toProdutoModel()
        }
    }
}
