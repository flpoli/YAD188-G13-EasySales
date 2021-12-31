package com.poli.prevendasomie.data.repository

import com.poli.prevendasomie.common.Env
import com.poli.prevendasomie.data.remote.DTO.ClientsDto
import com.poli.prevendasomie.data.remote.DTO.GetClientsCall
import com.poli.prevendasomie.data.remote.DTO.GetClientsParam
import com.poli.prevendasomie.data.remote.OmieAPI
import com.poli.prevendasomie.domain.model.Client
import com.poli.prevendasomie.domain.repository.ClientsRepository
import javax.inject.Inject

class ClientsRepositoryImpl @Inject constructor(
    private val api: OmieAPI
): ClientsRepository {

    override suspend fun getClients(): List<ClientsDto> {

        return api.getClientList(
            GetClientsCall(
                "ListarClientes",
                Env.APP_KEY,
                Env.APP_SECRET,
                GetClientsParam("N", 1, 1)
            ))
    }



    override suspend fun getClient(): List<Client> {
        TODO("Not yet implemented")
    }


}