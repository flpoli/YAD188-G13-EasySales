package com.poli.prevendasomie.presentation.components

import android.view.MenuItem
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavDrawer(){

    val items = listOf(

        DrawerItem(
            id = "1",
            title = "logout",
            contentDescription = "logout",
            icon = Icons.Default.Logout

    )

    )

    DrawerHeader()

    DrawerBody(items = items, onItemClick = {})
}


@Composable
fun DrawerHeader(){

    Box(
        contentAlignment  = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),

    ){

        Text(text = "Drawer header", fontSize = 60.sp)

    }

}

@Composable
fun DrawerBody(

    items: List<DrawerItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (DrawerItem) -> Unit

){

    Column(modifier) {


        items.forEach {

            item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    }
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = itemTextStyle,
                    modifier = Modifier.weight(1f)
                )
            }
        }


        }
    }



data class DrawerItem(

    val id: String,
    val title: String,
    val contentDescription: String,
    val icon: ImageVector

)