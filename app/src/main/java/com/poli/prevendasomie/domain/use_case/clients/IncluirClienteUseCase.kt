package com.poli.prevendasomie.domain.use_case.clients

import com.poli.prevendasomie.R
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.ReqResponse
import com.poli.prevendasomie.domain.model.ClientesCadastro
import com.poli.prevendasomie.domain.model.ListarClientes
import com.poli.prevendasomie.domain.repository.ClientsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

interface IncluirClienteUseCase {


    suspend operator fun invoke(clienteCadastro: ClientesCadastro): ReqResponse?

}