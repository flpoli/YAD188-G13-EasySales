package com.poli.prevendasomie.presentation.produtos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.poli.prevendasomie.R

@Composable
fun InfoBox(

    icon: ImageVector,
    iconColor: Color,
    bigText: String,
    smallText: String,
    textColor: Color

    ) {


    Row(verticalAlignment = Alignment.CenterVertically) {

        Icon(
            modifier = Modifier
                .padding(end = 10.dp)
                .size(32.dp),
            imageVector = icon,
            contentDescription = "Info Icon",
            tint = iconColor
        )

        Column {
            Text(

                text = bigText,
                color = textColor,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Black
            )
            Text(
                modifier = Modifier.alpha(ContentAlpha.medium),
                text = smallText,
                color = textColor,
                fontSize = MaterialTheme.typography.overline.fontSize,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun InfoBoxPreview(){
    InfoBox(
        icon = Icons.Default.AttachMoney,
        iconColor = MaterialTheme.colors.primary,
        bigText = "92.50",
        smallText = "preço unitário",
        textColor = Black
    )
}