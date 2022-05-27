package com.poli.prevendasomie.login.domain.repository

import android.util.Log
import com.poli.prevendasomie.common.Constants.APP_KEY
import com.poli.prevendasomie.common.Constants.APP_SECRET
import com.poli.prevendasomie.common.Resource
import com.poli.prevendasomie.data.local.dao.UserDao
import com.poli.prevendasomie.data.remote.BackEndApi
import com.poli.prevendasomie.data.remote.dto.ResponseSignUpDto
import com.poli.prevendasomie.data.remote.dto.toUserDataModel
import com.poli.prevendasomie.login.domain.model.Credentials
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: BackEndApi,
    private val dao: UserDao,
) : LoginRepository {
    override suspend fun login(credentials: Credentials): Resource<Response<Unit>> {

        return try {

            val call = api.executeLogin(credentials)

            if (call.code() == 200) {
                Resource.Success(call)
            } else {
                Resource.Error("${ call.errorBody() }")
            }
        } catch (e: HttpException) {

            Log.e("HttpException", "$e")

            Resource.Error(
                message = "Não foi possível logar: ${e.code()}, ${e.message()}"
            )
        } catch (e: SocketTimeoutException) {

            Log.e("SocketTimeoutException", "$e")

            Resource.Error(
                message = "Não foi possível logar. Vamos tentar novamente? ${e.cause}"
            )
        }
    }

    override suspend fun getUserDetails(token: String): Resource<ResponseSignUpDto> {

        val call = api.getUserDetails(token)

        dao.persistUserData(call.toUserDataModel())

        APP_KEY = dao.selectAllInfo().appKey.toString()
        APP_SECRET = dao.selectAllInfo().appSecret.toString()

        return Resource.Success(call)
    }
}
