package com.example.composedemo.ui.common

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composedemo.data.prefdatastore.UserStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun RegistrationScreen ( navController: NavController) {
    registration(navController)
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun registration( navController:NavController){
    val context= LocalContext.current
    val keyboardController= LocalSoftwareKeyboardController.current
    var store = UserStore(context)
    val tokenText = store.getAccessToken?.collectAsState(initial = "")

    val tokenValue = remember {
        mutableStateOf(TextFieldValue())
    }
    val pwdValue = remember {
        mutableStateOf(TextFieldValue())
    }
    Column(
        modifier = Modifier.clickable { keyboardController?.hide() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Signup", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = tokenText?.value?:"")

        Spacer(modifier = Modifier.height(15.dp))


        TextField(
            value = tokenValue.value,
            label = { Text(text = "Name") },
            onValueChange = { tokenValue.value = it },
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = pwdValue.value,
            label = { Text(text = "Password") },
            onValueChange = { pwdValue.value = it },
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                if (tokenValue.value.text.isNotEmpty() && pwdValue.value.text.isNotEmpty()) {
                    CoroutineScope(Dispatchers.IO).launch {

                        store.saveToken(tokenValue.value.text, pwdValue.value.text)
                        //context.finish()

                    }
                    navController.popBackStack()
                }else{
                    Toast.makeText(context,"Field should not empty", Toast.LENGTH_LONG).show()
                }
            }
        ) {
            Text(text = "Submit")
        }
    }
}
