package com.poli.prevendasomie.navigation

import com.poli.prevendasomie.common.Constants.CLIENT_DETAIL_ROUTE
import com.poli.prevendasomie.common.Constants.CLIENT_FORM_ROUTE
import com.poli.prevendasomie.common.Constants.CLIENT_LIST_ROUTE
import com.poli.prevendasomie.common.Constants.CLIENT_SELECTION_SCREEN
import com.poli.prevendasomie.common.Constants.LOGIN_ROUTE
import com.poli.prevendasomie.common.Constants.MAIN_SCREEN_ROUTE
import com.poli.prevendasomie.common.Constants.ONBOARDING_ROUTE
import com.poli.prevendasomie.common.Constants.ORDER_DETAIL_ROUTE
import com.poli.prevendasomie.common.Constants.ORDER_FORM_ROUTE
import com.poli.prevendasomie.common.Constants.ORDER_LIST_ROUTE
import com.poli.prevendasomie.common.Constants.PRODUCT_DETAIL_ROUTE
import com.poli.prevendasomie.common.Constants.PRODUCT_FORM_SCREEN
import com.poli.prevendasomie.common.Constants.PRODUCT_LIST_ROUTE
import com.poli.prevendasomie.common.Constants.PRODUCT_SELECTION_ROUTE
import com.poli.prevendasomie.common.Constants.SIGNUP_ROUTE

sealed class Screen(val route: String) {

    object OnBoardingScreen : Screen(ONBOARDING_ROUTE)
    object MainScreen : Screen(MAIN_SCREEN_ROUTE)
    object LoginScreen : Screen(LOGIN_ROUTE)
    object SignUpScreen : Screen(SIGNUP_ROUTE)

    object ClientListScreen : Screen(CLIENT_LIST_ROUTE)

    object ClientDetailScreen : Screen("$CLIENT_DETAIL_ROUTE/{clientId}") {

        fun passClientId(clientId: Long): String {
            return "$CLIENT_DETAIL_ROUTE/$clientId"
        }
    }

    object ClientSelectionScreen : Screen(CLIENT_SELECTION_SCREEN)
    object ClientFormScreen : Screen(CLIENT_FORM_ROUTE)

    object ProductListScreen : Screen(PRODUCT_LIST_ROUTE)

    object ProductDetailScreen : Screen("$PRODUCT_DETAIL_ROUTE/{productId}") {

        fun passProductId(productId: Long): String {
            return "$PRODUCT_DETAIL_ROUTE/$productId"
        }
    }
    object ProductFormScreen : Screen(PRODUCT_FORM_SCREEN)

    object ProductSelectionScreen : Screen(PRODUCT_SELECTION_ROUTE)

    object OrdersListScreen : Screen(ORDER_LIST_ROUTE)

    object OrderFormScreen : Screen(ORDER_FORM_ROUTE)

    object OrderDetailScreen : Screen("$ORDER_DETAIL_ROUTE/{orderId}") {

        fun passOrderId(orderId: Long): String {

            return "$ORDER_DETAIL_ROUTE/$orderId"
        }
    }
}
