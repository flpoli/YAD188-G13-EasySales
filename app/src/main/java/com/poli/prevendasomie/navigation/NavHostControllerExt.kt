package com.poli.prevendasomie.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import com.poli.prevendasomie.core.UiEvent

fun NavHostController.navigate(event: UiEvent.Navigate) {

    this.navigate(event.route)
}

@Composable
fun <T> NavHostController.NavigateForResult(keyResult: String, onResult: (T) -> Unit) {

    val valueScreenResult = currentBackStackEntry
        ?.savedStateHandle
        ?.getLiveData<T>(keyResult)?.observeAsState()

    valueScreenResult?.value?.let {

        onResult(it)

        currentBackStackEntry
            ?.savedStateHandle
            ?.remove<T>(keyResult)
    }
}
