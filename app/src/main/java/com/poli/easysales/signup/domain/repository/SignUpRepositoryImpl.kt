package com.poli.easysales.signup.domain.repository

import android.util.Log
import com.poli.easysales.common.Resource
import com.poli.easysales.data.remote.BackEndApi
import com.poli.easysales.signup.domain.model.UserData
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val api: BackEndApi
) : SignUpRepository {

    override suspend fun signUp(userData: UserData): Resource<Response<Unit>> {

        return try {

            val call = api.userRegistration(userData)

            if (call.code() == 200) {
                Resource.Success(call)
            } else {

                Resource.Error("${call.errorBody()}")
            }
        } catch (e: HttpException) {

            Log.e("HttpException", "$e")

            Resource.Error(
                message = "Não foi possível cadastrar: ${e.code()}, ${e.message()}"
            )
        } catch (e: SocketTimeoutException) {
            Resource.Error(
                message = "Não foi possível Cadastrar. Vamos tentar novamente? ${e.cause}"
            )
        }
    }
}
