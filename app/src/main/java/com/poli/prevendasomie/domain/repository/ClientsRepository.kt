package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.data.remote.DTO.ClientesCadastro


interface ClientsRepository {
    suspend fun getClients(): List<ClientesCadastro>
}