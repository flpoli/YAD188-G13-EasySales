package com.poli.easysales.data.util

import com.poli.easysales.domain.repository.Preferences
import io.sentry.Sentry

import io.sentry.protocol.User
import javax.inject.Inject

fun setSentryUser (preferences: Preferences) {


    val currentUser = User().apply {
        email = preferences.readUserSession().email.value
        username = preferences.readUserSession().username.value
        ipAddress
    }

    Sentry.setUser(currentUser)

}

fun clearSentryUser(){
    Sentry.configureScope { scope ->
        scope.user = null
    }
}

