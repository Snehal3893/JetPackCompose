package com.example.composedemo.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.composedemo.MainActivity
import com.example.composedemo.dashboard.view.activity.NavigationDrawerActivity
import com.example.composedemo.mvvm.view.activity.CreditCardScreenAcivity

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    createUI()
                }
            }

    }
  //  @ExperimentalMaterial3Api
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun createUI() {
        var value by remember {
            mutableStateOf("")
        }
        Column(
            modifier = androidx.compose.ui.Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Login")
            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
            OutlinedTextField(
                value = value, onValueChange = { newText ->
                    value = newText
                },
                label = { Text(text = "User Name") },
                placeholder = { Text(text = "Enter your name") },
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
            )
            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))

            OutlinedTextField(
                value = value, onValueChange = { newText ->
                    value = newText
                },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Enter password") },
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
            )
            //buttonClick()
            Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
            Button(
                onClick = {

                    startActivity(Intent(this@LoginActivity, NavigationDrawerActivity::class.java))
                },
                shape = RoundedCornerShape(size = 20.dp)
            ) {
                Text(text = "Submit")
            }
        }
    }

    @Composable
    fun buttonClick(
        onClick: () -> Unit,
        modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier,
        enable: Boolean = true,
        intrac: MutableInteractionSource = remember { MutableInteractionSource() },
        shapes: Shape = MaterialTheme.shapes.medium,
        border: BorderStroke? = null,
        colors: ButtonColors = ButtonDefaults.buttonColors(),
        contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
        content: @Composable RowScope.() -> Unit
    ) {

    }

}