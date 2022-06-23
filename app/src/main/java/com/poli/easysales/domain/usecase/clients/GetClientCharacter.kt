package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.domain.model.clientes.Caracteristica

interface GetClientCharacter {

    suspend operator fun invoke(codigoCliente: Long): List<Caracteristica>?
}
