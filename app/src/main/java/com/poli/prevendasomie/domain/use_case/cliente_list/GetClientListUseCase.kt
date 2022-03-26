package com.poli.prevendasomie.domain.use_case.cliente_list

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.domain.model.ListarClientes
import com.poli.prevendasomie.domain.repository.ClientsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetClientListUseCase @Inject constructor(private val repository: ClientsRepository) {

    operator fun invoke(): Flow<Resource<List<ListarClientes>>> = flow {


        try {
            emit(Resource.Loading<List<ListarClientes>>())
            val currPage: Int = 0
            val request = Request.ListClientsRequest(

                call = "ListarClientesDto",
                param = listOf(
                    Param.ParamListarClientes(
                        "N",
                        currPage.toString(),
                        "10"
                    )
            )
            )

            val clients = repository.getClientList(request)


        } catch (e: HttpException){

        } catch (e: IOException){

        }

    }


}