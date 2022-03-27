package com.poli.prevendasomie.domain.use_case

import com.poli.prevendasomie.domain.use_case.clients.GetClientListUseCase
import com.poli.prevendasomie.domain.use_case.clients.IncluirClienteUseCase

data class UseCases (

    val getClientsUseCase: GetClientListUseCase,
    val incluirClienteUseCase: IncluirClienteUseCase,

    )