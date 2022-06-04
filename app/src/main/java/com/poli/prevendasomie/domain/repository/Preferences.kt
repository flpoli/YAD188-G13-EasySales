package com.poli.prevendasomie.domain.repository

import com.poli.prevendasomie.signup.domain.model.UserData
import kotlinx.coroutines.flow.Flow

interface Preferences {

//    suspend fun saveOnBoardingState(completed: Boolean)
//    fun readOnBoardingState(): Flow<Boolean>


    fun saveUserSession(user: UserData)
    fun readUserSession(): UserData
    fun isUserLoggedIn(logged: Boolean)
    fun readLoginStatus(): Boolean



    companion object {

        const val KEY_USERNAME = "username"
        const val KEY_EMAIL = "email"
        const val KEY_APP_KEY =  "appKey"
        const val KEY_APP_SECRET = "appSecret"
        const val KEY_TOKEN = "token"
        const val KEY_IS_LOGGED = "should_login"

    }

}
