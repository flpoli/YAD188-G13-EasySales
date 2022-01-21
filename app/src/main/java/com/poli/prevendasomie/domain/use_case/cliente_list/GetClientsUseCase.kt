package com.poli.prevendasomie.domain.use_case.cliente_list

import com.poli.prevendasomie.common.Env.APP_KEY
import com.poli.prevendasomie.common.Env.APP_SECRET
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.remote.Param
import com.poli.prevendasomie.data.remote.Request
import com.poli.prevendasomie.domain.model.ClientList
import com.poli.prevendasomie.repository.ClientsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetClientsUseCase @Inject constructor(private val repository: ClientsRepository) {
    // os parâmetros da requisição deveriam aparecer no invoke()? tipo, request: Request..?


    operator fun invoke(): Flow<Resource<List<ClientList>>> = flow {


        try {
            emit(Resource.Loading<List<ClientList>>())
            // os parâmetros da requisição deveriam ser passados aqui ou na viewmodel?
            val currPage: Int = 0
            val request = Request.ListClientsRequest(

                "ListarClientes",
                APP_KEY,
                APP_SECRET,
                listOf(
                    Param.ParamListarClientes(
                        "N",
                        currPage.toString(), // int na data class..? maybe
                        "10"
                    )
            )
            )

            val clients = repository.getClientList(request)


            //emit(Resource.Success<List<clients.data>>())

        } catch (e: HttpException){

        } catch (e: IOException){

        }

    }


}