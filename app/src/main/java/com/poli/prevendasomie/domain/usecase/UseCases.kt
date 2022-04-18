package com.poli.prevendasomie.domain.usecase

import com.poli.prevendasomie.domain.usecase.clients.GetClientListUseCaseImpl
import com.poli.prevendasomie.domain.usecase.clients.IncluirClienteUseCase

data class UseCases(

    val getClientsUseCase: GetClientListUseCaseImpl,
    val incluirClienteUseCase: IncluirClienteUseCase,

)
