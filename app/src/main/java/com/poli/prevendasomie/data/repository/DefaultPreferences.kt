package com.poli.prevendasomie.data.repository

import android.content.SharedPreferences
import com.poli.prevendasomie.common.Constants.APP_KEY
import com.poli.prevendasomie.common.Constants.APP_SECRET
import com.poli.prevendasomie.domain.repository.Preferences
import com.poli.prevendasomie.domain.repository.Preferences.Companion.KEY_IS_LOGGED
import com.poli.prevendasomie.signup.domain.model.Email
import com.poli.prevendasomie.signup.domain.model.UserData
import com.poli.prevendasomie.signup.domain.model.Username


class DefaultPreferences(private val sharedPref: SharedPreferences) : Preferences {



    override fun saveUserSession(user: UserData) {


        sharedPref.edit().putString(Preferences.KEY_USERNAME, user.username.value).apply()
        sharedPref.edit().putString(Preferences.KEY_EMAIL, user.email.value).apply()
        sharedPref.edit().putString(Preferences.KEY_APP_KEY, user.appKey).apply()
        sharedPref.edit().putString(Preferences.KEY_APP_SECRET, user.appSecret).apply()
        sharedPref.edit().putString(Preferences.KEY_TOKEN, user.token).apply()


    }

    override fun readUserSession(): UserData {

        val username = Username(sharedPref.getString(Preferences.KEY_USERNAME, "") ?: "")
        val email = Email(sharedPref.getString(Preferences.KEY_EMAIL, "") ?: "")

        APP_KEY = sharedPref.getString(Preferences.KEY_APP_KEY, "") ?: ""
        APP_SECRET = sharedPref.getString(Preferences.KEY_APP_SECRET,"") ?: ""

            return UserData(
            username = username,
            email = email,
            appKey = sharedPref.getString(Preferences.KEY_APP_KEY, "") ?: "",
            appSecret = sharedPref.getString(Preferences.KEY_APP_SECRET, "") ?: "",
            token = sharedPref.getString(Preferences.KEY_TOKEN, "") ?: ""
        )

    }

    override fun isUserLoggedIn(logged: Boolean){

        sharedPref.edit().putBoolean(KEY_IS_LOGGED, logged).apply()

    }

    override fun readLoginStatus(): Boolean {

        return sharedPref.getBoolean(Preferences.KEY_IS_LOGGED, false)

    }


}



