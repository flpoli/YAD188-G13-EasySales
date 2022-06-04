package com.poli.prevendasomie.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
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
import androidx.navigation.NavHostController
import com.poli.prevendasomie.domain.repository.Preferences
import com.poli.prevendasomie.navigation.Screen
import com.poli.prevendasomie.signup.domain.model.Email
import com.poli.prevendasomie.signup.domain.model.UserData
import com.poli.prevendasomie.signup.domain.model.Username
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavDrawer(
    navController: NavHostController,
    preferences: Preferences,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
){

    val items = listOf(

        DrawerItem(
            id = "1",
            title = "logout",
            contentDescription = "logout",
            icon = Icons.Default.Logout

    )

    )

    DrawerHeader()

    DrawerBody(
        items = items,
        onItemClick = {

            if(it.id == "1"){

                preferences.isUserLoggedIn(false)
                preferences.saveUserSession(

                    user = UserData(
                        Username(""), Email(""), appKey = "", appSecret = ""
                    )
                )
                scope.launch {

                    scaffoldState.drawerState.close()
                    navController.navigate(Screen.LoginScreen.route)
                }




            }

        }



    )
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