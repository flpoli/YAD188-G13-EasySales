package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.data.remote.DTO.ClientesCadastro
import com.poli.prevendasomie.data.remote.DTO.ClientsDto
import com.poli.prevendasomie.domain.model.Client


interface ClientsRepository {
    suspend fun getClients(): List<ClientsDto>
    suspend fun getClient(): List<Client>
}