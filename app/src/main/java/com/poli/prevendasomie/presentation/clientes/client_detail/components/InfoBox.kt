package com.poli.prevendasomie.presentation.clientes.client_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoBox(

    title: String,
    info: String,
    subtitle: String,

) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(start = 10.dp)
    ){

    Column(modifier = Modifier.align(Alignment.CenterStart)) {


        Text(
            text = title,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = 1.5.sp,
            lineHeight = 16.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .alpha(1f),
            color = Color(red = 0f, green = 0f, blue = 0f, alpha = 0.6000000238418579f),
            fontWeight = FontWeight.Medium,

            )

        Text(
            text = info,
            textAlign = TextAlign.Start,
            fontSize = 18.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = 0.15000000596046448.sp,
            lineHeight = 24.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .alpha(1f),
            color = Color(red = 0f, green = 0f, blue = 0f, alpha = 0.8700000047683716f),
            fontWeight = FontWeight.Normal,
        )

        Text(
            text = subtitle,
            textAlign = TextAlign.Start,
            fontSize = 14.sp,
            textDecoration = TextDecoration.None,
            letterSpacing = 0.25.sp,
            lineHeight = 20.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .fillMaxWidth()
                .alpha(1f),
            color = Color(red = 0f, green = 0f, blue = 0f, alpha = 0.6000000238418579f),
            fontWeight = FontWeight.Normal,
        )
    }


    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Preview(showBackground = true)
@Composable
fun PreviewInfoBox(){

    InfoBox(
        title = "Nome",
        info = "Joe Doe",
        subtitle = "Joe Doe System LTDA"

    )


}