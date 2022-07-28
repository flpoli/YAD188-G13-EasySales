package com.poli.easysales.domain.usecase.clients

import com.poli.easysales.data.remote.dto.CepResponse


interface GetAddressByCepUseCase  {

    suspend operator fun invoke(cep: String): CepResponse?
}