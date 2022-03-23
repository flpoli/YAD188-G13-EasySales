package com.poli.prevendasomie.core


sealed class UiEvent {

    data class Navigate(val route: String): UiEvent()
    object NavigateUp: UiEvent()
    data class ShowSnackbar(val message: UiText): UiEvent()
}