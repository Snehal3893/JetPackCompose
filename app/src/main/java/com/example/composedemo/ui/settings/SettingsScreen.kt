package com.example.composedemo.ui.settings

import android.content.Intent
import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.R
import com.example.composedemo.ui.changepwd.ChangePassword
import com.example.composedemo.ui.dashboard.view.activity.AllDestinations
import com.example.composedemo.ui.dashboard.view.activity.AppNavigationActions
import com.example.composedemo.ui.login.LoginActivity

import com.example.composedemo.mvvm.view.activity.CreditCardScreenAcivity


@Composable
fun SettingsScreen() {
    var openDialog = remember {
        mutableStateOf(false)
    }
    var context= LocalContext.current
    var isClickable = remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = {

            }),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {

        Row(modifier = Modifier.padding(20.dp)) {
            Image(painter = painterResource(R.drawable.profile), contentDescription = "Profile Image",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(8.dp)
                    .size(60.dp)
                    .clip((CircleShape)))
            Column(
                modifier = Modifier.weight(1f),
                Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Joy",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    text = "Mobile Number:" + " 9988776655",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp
                    )
                )

            }


        }
        Spacer(modifier = Modifier.height(35.dp))

        Column(modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()) {
            Row(Modifier.clickable {

            }) {

                Text(
                    text = "Change Password",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                )

                Icon(
                    imageVector = Icons.Default.ArrowForward, contentDescription = null
                )

            }

            Spacer(modifier = Modifier.height(15.dp))
            Row {

                Text(
                    text = "Logout",
                    Modifier.clickable {
                                       isClickable.value=true
                        openDialog.value=true
                    },
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                )
                Icon(
                    imageVector = Icons.Default.ArrowForward, contentDescription = null
                )
                if (isClickable.value) {
                    logoutDialogShow(openDialog)
                }
            }

        }
    }


}
@Composable
fun logoutDialogShow(openDialog : MutableState<Boolean>){
    var context= LocalContext.current
    MaterialTheme{
        Column {
            if (openDialog.value){
                AlertDialog(onDismissRequest = {
                   openDialog.value=false
                },
                    title = {
                        Text(text = "Logout")
                    },
                    text = {Text(text = "Are you sure you want to logout?")},
                    confirmButton = {
                        Button(onClick = {
                            openDialog.value=false
                            context.startActivity(Intent(context, LoginActivity::class.java))

                        }) {
                            Text(text = "Yes")
                        }
                    },
                    dismissButton = {
                        Button(onClick =  {
                            openDialog.value=false

                        }){
                            Text(text = "No")

                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}
