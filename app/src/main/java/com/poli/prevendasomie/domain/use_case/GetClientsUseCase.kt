package com.poli.prevendasomie.domain.use_case

import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.domain.model.ClientList
import com.poli.prevendasomie.repository.ClientsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetClientsUseCase @Inject constructor(private val repository: ClientsRepository) {

    operator fun invoke(): Flow<Resource<List<ClientList>>> = flow {

        try {
            emit(Resource.Loading<List<ClientList>>())
            val clients = repository.getClientList().map { it.toClientList() }
            //emit(Resource.Success<List<ListarClientes>>())

        } catch (e: HttpException){

        } catch (e: IOException){

        }

    }


}