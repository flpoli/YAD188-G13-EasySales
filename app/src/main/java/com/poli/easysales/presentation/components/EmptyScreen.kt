package com.poli.easysales.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.poli.easysales.domain.model.produtos.ProdutoServicoCadastro
import com.poli.easysales.ui.theme.DarkGrey
import com.poli.easysales.ui.theme.LightGrey
import com.poli.prevendasomie.R
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(
    error: LoadState.Error? = null,
    heroes: LazyPagingItems<ProdutoServicoCadastro>? = null
) {

    var message by remember {
        mutableStateOf("")
    }
    var icon by remember {
        mutableStateOf(R.drawable.ic_search_document)
    }

    if (error != null) {
        message = parseErrorMessage(error = error)
        icon = R.drawable.ic_network_error
    }

    var startAnimation by remember {

        mutableStateOf(false)
    }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) ContentAlpha.disabled else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
    }

    EmptyContent(
        alphaAnim = alphaAnim,
        icon = icon,
        message = message,
        heroes = heroes,
        error = error
    )
}

@Composable
fun EmptyContent(
    alphaAnim: Float,
    icon: Int,
    message: String,
    heroes: LazyPagingItems<ProdutoServicoCadastro>? = null,
    error: LoadState.Error? = null

) {

    var isRefreshing by remember {
        mutableStateOf(false)
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
        swipeEnabled = error != null,
        onRefresh = {
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                modifier = Modifier
                    .size(120.dp)
                    .alpha(alphaAnim),
                painter = painterResource(id = icon),
                contentDescription = stringResource(R.string.network_error_icon),
                tint = if (isSystemInDarkTheme()) LightGrey else DarkGrey
            )
            Text(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .alpha(alphaAnim),
                text = message,
                textAlign = TextAlign.Center,
                color = if (isSystemInDarkTheme()) LightGrey else DarkGrey,
                fontWeight = FontWeight.Medium,
                fontSize = MaterialTheme.typography.subtitle1.fontSize

            )
        }
    }
}

fun parseErrorMessage(error: LoadState.Error): String {

    return when (error.error) {
        is SocketTimeoutException -> {
            "Server Unavailable: $error"
        }
        is ConnectException -> {
            "Internet Unavailable: $error"
        }
        is HttpException -> {
            "Request error: $error"
        }
        else -> "Unknown Error: $error"
    }
}
