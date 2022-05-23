package com.poli.prevendasomie.domain.usecase

import com.poli.prevendasomie.domain.usecase.clients.GetClientDetailsUseCase
import com.poli.prevendasomie.domain.usecase.clients.GetClientListForSelectionUseCase
import com.poli.prevendasomie.domain.usecase.clients.GetClientListUseCase
import com.poli.prevendasomie.domain.usecase.pedidos.GetOrderDetail
import com.poli.prevendasomie.domain.usecase.pedidos.GetOrdersListUseCase
import com.poli.prevendasomie.domain.usecase.pedidos.GetProductListForSelection
import com.poli.prevendasomie.domain.usecase.pedidos.InsertSelectedClientUseCase
import com.poli.prevendasomie.domain.usecase.products.GetProductsListUseCase
import com.poli.prevendasomie.domain.usecase.products.GetSelectedProduct

data class UseCases(

    val getProductListUseCase: GetProductsListUseCase,
    val getSelectedProduct: GetSelectedProduct,
    val getClientListUseCase: GetClientListUseCase,
    val getOrdersListUseCase: GetOrdersListUseCase,
    val getSelectedClientUseCase: GetClientDetailsUseCase,
    val getClientListForSelectionUseCase: GetClientListForSelectionUseCase,
    val insertSelectedClientUseCase: InsertSelectedClientUseCase,
    val getOrderDetail: GetOrderDetail,
    val getProductListForSelection: GetProductListForSelection

)
