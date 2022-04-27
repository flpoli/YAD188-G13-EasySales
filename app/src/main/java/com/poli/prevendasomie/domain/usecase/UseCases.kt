package com.poli.prevendasomie.domain.usecase

import com.poli.prevendasomie.domain.usecase.clients.GetClientListUseCase
import com.poli.prevendasomie.domain.usecase.products.GetProductsListUseCase

data class UseCases(

    val getProductListUseCase: GetProductsListUseCase,
    val getClientListUseCase: GetClientListUseCase

)
