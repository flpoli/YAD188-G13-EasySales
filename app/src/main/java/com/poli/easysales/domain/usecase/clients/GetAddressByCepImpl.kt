package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.data.remote.dto.CepResponse
import com.poli.easysales.domain.repository.ClientsRepository
import javax.inject.Inject

class GetAddressByCepImpl
    @Inject constructor(private val repository: ClientsRepository): GetAddressByCepUseCase {

    override suspend fun invoke(cep: String): CepResponse? {

        val addressData = repository.getAddressByCep(cep)

        return if(addressData.code() == 200){
            addressData.body()
        } else {
            null
        }
    }
}