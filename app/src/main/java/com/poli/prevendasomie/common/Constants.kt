package com.poli.prevendasomie.common

object Constants {
    const val PREFERENCES_NAME = "app_preferences"
    const val PREFERENCES_KEY = "on_boarding_completed"

    var APP_KEY = ""
    var APP_SECRET = ""

    // Navigation routes

    const val MAIN_SCREEN_ROUTE = "main_screen"
    const val CLIENT_LIST_ROUTE = "client_list_screen"
    const val CLIENT_DETAIL_ROUTE = "client_detail_screen"
    const val LOGIN_ROUTE = "login_screen"
    const val SIGNUP_ROUTE = "signup_screen"
    const val CLIENT_FORM_ROUTE = "client_form_screen"

    const val PRODUCT_LIST_ROUTE = "product_list_screen"

    const val ORDER_LIST_ROUTE = "order_list_screen"
    const val ORDER_FORM_ROUTE = "order_form_screen"


    const val API_PAGE_SIZE: Int = 30
    const val CACHE_TIMEOUT: Int = 1440
}
