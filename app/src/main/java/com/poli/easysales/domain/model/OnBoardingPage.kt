package com.poli.easysales.domain.model

import androidx.annotation.RawRes
import com.poli.prevendasomie.R

sealed class OnBoardingPage(

    @RawRes
    val anim: Int,
    val title: String,
    val description: String

) {

    object First : OnBoardingPage(
        anim = R.raw.coin,
        title = "TESTE",
        description = "",
    )
    object Second : OnBoardingPage(
        anim = R.raw.scanning,
        title = "TESTE",
        description = "",
    )
    object Third : OnBoardingPage(
        anim = R.raw.addtocartanin,
        title = "TESTE",
        description = "",
    )
}
