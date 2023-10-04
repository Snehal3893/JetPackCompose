package com.example.composedemo.ui.common

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composedemo.data.prefdatastore.UserStore
import com.example.composedemo.ui.dashboard.view.activity.AllDestinations

@Composable
fun LoginScreen(navController: NavHostController) {
   createUI(navController)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun createUI(navController: NavHostController) {
    val context= LocalContext.current
    val store = UserStore(context)
    val tokenText = store.getAccessToken.collectAsState(initial = "")
    val pwdText = store.getPwd.collectAsState(initial = "")
    Log.d("TAG","Login name::"+tokenText.value)
    Log.d("TAG","Login pwd::"+pwdText.value)

    var valueName by remember {
        mutableStateOf("")
    }
    var valuePwd by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Login")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = valueName, onValueChange = { newText ->
                valueName = newText
            },
            label = { Text(text = "User Name") },
            placeholder = { Text(text = "Enter user name") }
            //  textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = valuePwd, onValueChange = { newText ->
                valuePwd = newText
            },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter password") }
            // textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
        )
        //buttonClick()
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (valueName.equals(tokenText.value) && valuePwd.equals(pwdText.value)) {
                    navController.navigate(AllDestinations.HOME)
                }else{
                    Toast.makeText(context,"Please enter valid credential", Toast.LENGTH_LONG).show()
                }
            },
            shape = RoundedCornerShape(size = 20.dp)
        ) {
            Text(text = "Submit")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "You don't have account ? Click here",
            Modifier.clickable {
               // callNextActivity()
                navController.navigate(AllDestinations.REGISTRATION)

            },
            style = TextStyle(
                color = Color.Black,
                fontSize = 15.sp
            )
        )

    }
}

