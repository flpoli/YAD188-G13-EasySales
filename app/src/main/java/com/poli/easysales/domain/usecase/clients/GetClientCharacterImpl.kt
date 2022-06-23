package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.domain.mappers.toCaracteristicaModel
import com.poli.easysales.domain.model.clientes.Caracteristica
import com.poli.easysales.domain.repository.ClientsRepository
import io.sentry.Sentry
import javax.inject.Inject

class GetClientCharacterImpl
@Inject constructor(private val repository: ClientsRepository) : GetClientCharacter {

    override suspend fun invoke(codigoCliente: Long): List<Caracteristica>? {

        return try {
            repository.getClientCarac(codigoCliente)?.caracteristicas?.map { it.toCaracteristicaModel() }
        } catch (e: Exception) {

            Sentry.captureException(e)
            return null
        }
    }
}
