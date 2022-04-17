package com.poli.prevendasomie.domain.use_case

import com.poli.prevendasomie.domain.use_case.clients.GetClientListUseCaseImpl
import com.poli.prevendasomie.domain.use_case.clients.IncluirClienteUseCase

data class UseCases(

    val getClientsUseCase: GetClientListUseCaseImpl,
    val incluirClienteUseCase: IncluirClienteUseCase,

    )
