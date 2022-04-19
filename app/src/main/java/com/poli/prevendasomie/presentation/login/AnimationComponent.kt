package com.poli.prevendasomie.presentation.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.poli.prevendasomie.R

@Composable
fun AnimationComponent() {

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.loginamination)
    )

    val progress by animateLottieCompositionAsState(composition)

    LottieAnimation(composition = composition, progress = progress)
}
