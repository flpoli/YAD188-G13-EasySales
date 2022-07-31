package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.common.Resource
import com.poli.easysales.data.remote.dto.ReqResponse
import com.poli.easysales.domain.repository.ClientsRepository
import com.poli.easysales.domain.repository.Preferences
import javax.inject.Inject

class DeleteClientByCodeImpl
    @Inject constructor(
        private val repository: ClientsRepository,
        private val preferences: Preferences
    ): DeleteClientByCodeUseCase {


    override suspend fun invoke(codCli: Long): Resource<ReqResponse?> {


        val call = repository.deleteClientByCode(codCli)

        return if(call.data?.faultCode.isNullOrEmpty()){

            Resource.Error(data = call.data, message = call.data?.faultString.orEmpty())
        } else {
            Resource.Success(call.data)
        }


    }
}