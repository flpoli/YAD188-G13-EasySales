package com.poli.easysales.domain.usecase

import com.poli.easysales.domain.usecase.clients.DeleteClientByCodeUseCase
import com.poli.easysales.domain.usecase.clients.GetClientCharacter
import com.poli.easysales.domain.usecase.clients.GetClientDetailsUseCase
import com.poli.easysales.domain.usecase.clients.GetClientListForSelectionUseCase
import com.poli.easysales.domain.usecase.clients.GetClientListUseCase
import com.poli.easysales.domain.usecase.clients.GetOrdersForClient
import com.poli.easysales.domain.usecase.pedidos.CreateNewOrderUseCase
import com.poli.easysales.domain.usecase.pedidos.GetOrderDetail
import com.poli.easysales.domain.usecase.pedidos.GetOrdersListUseCase
import com.poli.easysales.domain.usecase.pedidos.GetProductListForSelection
import com.poli.easysales.domain.usecase.pedidos.InsertSelectedClientUseCase
import com.poli.easysales.domain.usecase.products.GetProductsListUseCase
import com.poli.easysales.domain.usecase.products.GetSelectedProduct

data class UseCases(

    val getProductListUseCase: GetProductsListUseCase,
    val getSelectedProduct: GetSelectedProduct,
    val getClientListUseCase: GetClientListUseCase,
    val getClientCharacter: GetClientCharacter,
    val deleteClientByCode: DeleteClientByCodeUseCase,
    val getOrdersListUseCase: GetOrdersListUseCase,
    val getSelectedClientUseCase: GetClientDetailsUseCase,
    val getClientListForSelectionUseCase: GetClientListForSelectionUseCase,
    val insertSelectedClientUseCase: InsertSelectedClientUseCase,
    val getOrderDetail: GetOrderDetail,
    val getProductListForSelection: GetProductListForSelection,
    val getOrdersForClient: GetOrdersForClient,
    val createNewOrderUsecase: CreateNewOrderUseCase

)
