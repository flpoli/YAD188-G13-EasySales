package com.poli.prevendasomie.common

object Constants {

    const val PREFERENCES_NAME = "app_preferences"
    const val PREFERENCES_KEY = "on_boarding_completed"

    var APP_KEY: String = ""
    var APP_SECRET: String = ""

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
    const val PRODUCTS_KEY_TABLE = "products_keys"
    const val ORDERS_TABLE = "orders_tb"
    const val ORDERS_KEY_TABLE = "orders_keys"
    const val CLIENTS_TABLE = "clients_tb"
    const val CLIENT_KEY_TABLE = "clients_keys"

    // ERP Api http routes
    const val BASE_ERP_URL: String = "https://app.omie.com.br/api/v1/"
    const val LOGIN_URL: String = "https://eazysales-api.herokuapp.com/"
    const val LOGIN_URL_LOCAL: String = "http://10.0.2.2:9000/"
    const val CLIENTS_ENDPOINT = "geral/clientes/"
    const val PRODUCTS_ENDPOINT = "geral/produtos/"
    const val ORDERS_ENDPOINT = "produtos/pedido/"

    // ERP API calls

    const val CALL_LISTAR_PEDIDOS = "ListarClientes"
    const val CALL_CONSULTAR_CLIENTE = "ConsultarCliente"
    const val CALL_INCLUIR_CLIENTE = "IncluirCliente"

    const val CALL_LISTAR_PRODUTOS = "ListarProdutos"

    const val API_PAGE_SIZE: Int = 30
    const val CACHE_TIMEOUT: Int = 1440
}
