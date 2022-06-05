package com.poli.easysales.presentation.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.poli.easysales.common.Constants.ON_BOARDING_PAGE_COUNT
import com.poli.easysales.domain.model.OnBoardingPage
import com.poli.easysales.presentation.components.AnimationComponent
import com.poli.easysales.ui.theme.activeIndicatorColor
import com.poli.easysales.ui.theme.inactiveIndicatorColor

@ExperimentalPagerApi
@Composable
fun OnboardingScreen(
    navController: NavHostController,
    // viewModel: OnboardingViewModel
) {

    val pages = listOf(OnBoardingPage.First, OnBoardingPage.Second, OnBoardingPage.Third)
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = ON_BOARDING_PAGE_COUNT,
            state = pagerState,
            verticalAlignment = Alignment.Top

        ) {

                position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.activeIndicatorColor,
            inactiveColor = MaterialTheme.colors.inactiveIndicatorColor,
            indicatorWidth = 12.dp,
            spacing = 8.dp
        )
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        AnimationComponent(
            animResource = onBoardingPage.anim,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .scale(10f)
        )

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title,
            color = MaterialTheme.colors.onSurface,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center

        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 8.dp),
            text = onBoardingPage.description,
            color = MaterialTheme.colors.onSurface,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}
