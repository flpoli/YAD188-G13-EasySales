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

    // Database constants
    const val DATA_BASE_NAME = "ErpDatabase"
    const val USER_TABLE = "user_tb"
    const val PRODUCTS_TABLE = "products_tb"
    const val ORDERS_TABLE = "orders_tb"

    // ERP api constants
    const val BASE_ERP_URL: String = "https://app.omie.com.br/api/v1/"
    const val LOGIN_URL: String = "https://eazysales-api.herokuapp.com/"
    const val LOGIN_URL_LOCAL: String = "http://10.0.2.2:9000/"
    const val CLIENTS_ENDPOINT = "geral/clientes/"
    const val PRODUCTS_ENDPOINT = "geral/produtos/"
    const val ORDERS_ENDPOINT = "produtos/pedido/"

    const val API_PAGE_SIZE: Int = 30
    const val CACHE_TIMEOUT: Int = 1440
}
