package com.poli.prevendasomie.domain.model

import androidx.annotation.RawRes
import com.airbnb.lottie.Lottie
import com.poli.prevendasomie.R

sealed class OnBoardingPage(

    @RawRes
    val anim: Int,
    val title: String,
    val description: String

    ){

        object First: OnBoardingPage(
            anim = R.raw.coin,
            title = "",
            description = "",
        )
        object Second: OnBoardingPage(
            anim = R.raw.coin,
            title = "",
            description = "",
        )
        object Third: OnBoardingPage(
            anim = R.raw.coin,
            title = "",
            description = "",
        )

}
