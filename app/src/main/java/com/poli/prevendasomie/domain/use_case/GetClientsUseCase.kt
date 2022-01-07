package com.poli.prevendasomie.domain.use_case

//import com.poli.prevendasomie.common.Resource
//import com.poli.prevendasomie.data.remote.dto.toClients
//import com.poli.prevendasomie.domain.model.Client
//import com.poli.prevendasomie.domain.repository.ClientsRepository
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import retrofit2.HttpException
//import java.io.IOException
//import javax.inject.Inject
//
//class GetClientsUseCase @Inject constructor(private val repository: ClientsRepository) {
//
//    operator fun invoke(): Flow<Resource<List<Client>>> = flow {
//
//        try {
//            emit(Resource.Loading<List<Client>>())
//            val clients = repository.getClients().map { it.toClients() }
//            //emit(Resource.Success<List<Client>>())
//
//        } catch (e: HttpException){
//
//        } catch (e: IOException){
//
//        }
//
//    }
//
//
//}