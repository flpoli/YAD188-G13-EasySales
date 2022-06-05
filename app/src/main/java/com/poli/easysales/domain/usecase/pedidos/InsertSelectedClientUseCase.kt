package com.poli.easysales.domain.usecase.pedidos

import com.poli.easysales.domain.model.clientes.ClientesCadastro

interface InsertSelectedClientUseCase {

    suspend operator fun invoke(selectedClient: ClientesCadastro)
}
