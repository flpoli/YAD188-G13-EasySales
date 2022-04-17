package com.poli.prevendasomie.domain.use_case.clients

import com.poli.prevendasomie.R
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.data.remote.responses.toClientesCadastro
import com.poli.prevendasomie.domain.model.ClientesCadastro
import com.poli.prevendasomie.domain.repository.ClientsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetClienteDetailUseCaseImpl
@Inject constructor(private val repository: ClientsRepository) : GetClientDetailsUseCase {

    override suspend fun invoke(codigoClienteOmie: String): Flow<Resource<ClientesCadastro>> = flow {

        val request = Request.ClientByCodeRequest(
            param = listOf(Param.ParamConsultarCliente(codigoClienteOmie))
        )

        try {
            emit(Resource.Loading<ClientesCadastro>())
            val call = repository.getClientByCode(request).toClientesCadastro()
            emit(Resource.Success(call))
        } catch (e: HttpException) {
            emit(Resource.Error<ClientesCadastro>(e.localizedMessage ?: R.string.on_http_error.toString()))
        } catch (e: IOException) {
            emit(Resource.Error<ClientesCadastro>(e.localizedMessage ?: R.string.on_http_error.toString()))
        }
    }
}
