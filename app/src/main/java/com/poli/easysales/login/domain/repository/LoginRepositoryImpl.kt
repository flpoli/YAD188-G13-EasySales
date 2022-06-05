package com.poli.easysales.login.domain.repository

import android.util.Log
import com.poli.easysales.common.Resource
import com.poli.easysales.data.local.dao.UserDao
import com.poli.easysales.data.remote.BackEndApi
import com.poli.easysales.data.remote.dto.ResponseSignUpDto
import com.poli.easysales.domain.repository.Preferences
import com.poli.easysales.login.domain.model.Credentials
import com.poli.easysales.signup.domain.model.Email
import com.poli.easysales.signup.domain.model.UserData
import com.poli.easysales.signup.domain.model.Username
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: BackEndApi,
    private val dao: UserDao,
    private val preferences: Preferences
) : LoginRepository {
    override suspend fun login(credentials: Credentials): Resource<Response<Unit>> {

        return try {

            val call = api.executeLogin(credentials)

            if (call.code() == 200) {

                preferences.isUserLoggedIn(true)

                Resource.Success(call)
            } else {

                preferences.isUserLoggedIn(false)

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

        val currentUser = UserData(

            username = Username(call.username),
            email = Email(call.email),
            appKey = call.appKey,
            appSecret = call.appSecret,

        )

        preferences.saveUserSession(currentUser)

        // dao.persistUserData(call.toUserDataModel())
        // dao.selectAllInfo().appKey.toString()
        // dao.selectAllInfo().appSecret.toString()

        preferences.readUserSession()

        return Resource.Success(call)
    }
}