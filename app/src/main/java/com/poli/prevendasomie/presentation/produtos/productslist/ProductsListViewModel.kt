package com.poli.prevendasomie.presentation.produtos.productslist

import androidx.lifecycle.ViewModel
import androidx.paging.map
import com.poli.prevendasomie.domain.mappers.toProdutoModel
import com.poli.prevendasomie.domain.usecase.UseCases
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
