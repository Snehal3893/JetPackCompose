package com.example.composedemo.registration

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.example.composedemo.prefdatastore.UserStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                registration()
            }
        }

    }


    @OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
    @Composable
    fun registration(){
        val context= LocalContext.current
        val keyboardController= LocalSoftwareKeyboardController.current
        val store = UserStore(context)
        val tokenText = store.getAccessToken.collectAsState(initial = "")

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

            Text(text = tokenText.value)

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
                            finish()

                        }
                    }else{
                            Toast.makeText(context,"Field should not empty", Toast.LENGTH_LONG).show()
                        }
                }
            ) {
                Text(text = "Submit")
            }
        }
    }

}