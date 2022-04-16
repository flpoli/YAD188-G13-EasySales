package com.poli.prevendasomie.common

import com.poli.prevendasomie.data.remote.responses.ResponseSignUpDto

object Constants {
    const val PREFERENCES_NAME = "app_preferences"
    const val PREFERENCES_KEY = "on_boarding_completed"

    val APPKEY = ResponseSignUpDto().appKey
    val APPSECRET = ResponseSignUpDto().appSecret


}
