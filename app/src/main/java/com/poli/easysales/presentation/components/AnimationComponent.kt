package com.poli.easysales.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun AnimationComponent(
    modifier: Modifier = Modifier,
    animResource: Int
) {

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(animResource)
    )

    val progress by animateLottieCompositionAsState(composition)

    LottieAnimation(composition = composition, progress = progress)
}
