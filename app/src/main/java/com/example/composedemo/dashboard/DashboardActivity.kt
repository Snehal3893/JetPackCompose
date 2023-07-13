package com.example.composedemo.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
class DashboardActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

                NavHost(navController, startDestination = IntroNav.INTRO_ROUTE) {
                    introGraph(navController)
                    //mainGraph(navController)
                }

        }
    }

    @Composable
    fun MotivationScreen(navController: NavController) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Motivation")
            Button(onClick = {
                navController.navigate(IntroNav.INTRO_RECOMMENDATION_SCREEN)
            }) {
                Text("Go to recommendations")
            }
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Go Back")
            }
        }
    }

  @Composable
    fun WelcomeScreen(navController: NavController) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("WelcomeScreen")
            Button(onClick = {
                navController.navigate(IntroNav.INTRO_MOTIVATION_SCREEN)
            }) {
                Text("Go to Motivation")
            }
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Go Back")
            }
        }
    }
@Composable
    fun RecommendationScreen(navController: NavController) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("RecommendationScreen")
            Button(onClick = {
                navController.navigate(IntroNav.INTRO_WELCOME_SCREEN)
            }) {
                Text("Go to Next")
            }
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Go Back")
            }
        }
    }
@Composable
    fun HomeScreen(navController: NavController) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("HomeScreen")
            Button(onClick = {
                navController.navigate(IntroNav.INTRO_RECOMMENDATION_SCREEN)
            }) {
                Text("Go to HomeScreen")
            }
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Go Back")
            }
        }
    }

@Composable
    fun SettingsScreen(navController: NavController) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("SettingsScreen")
            Button(onClick = {
                navController.navigate(IntroNav.INTRO_RECOMMENDATION_SCREEN)
            }) {
                Text("Go to SettingsScreen")
            }
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Go Back")
            }
        }
    }

@Composable
    fun AboutScreen(navController: NavController) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("AboutScreen")
            Button(onClick = {
                navController.navigate(IntroNav.INTRO_RECOMMENDATION_SCREEN)
            }) {
                Text("Go to AboutScreen")
            }
            Button(onClick = {
                navController.popBackStack()
            }) {
                Text("Go Back")
            }
        }
    }

    @Preview
    @Composable
    fun MotivationPreview() {
        val navController = rememberNavController()
        MotivationScreen(navController = navController)
    }
    fun NavGraphBuilder.introGraph(navController: NavController) {
        navigation(startDestination = IntroNav.INTRO_WELCOME_SCREEN, route = IntroNav.INTRO_ROUTE) {
            composable(IntroNav.INTRO_WELCOME_SCREEN){
                WelcomeScreen(navController)
            }
            composable(IntroNav.INTRO_MOTIVATION_SCREEN){
                MotivationScreen(navController)
            }
            composable(IntroNav.INTRO_RECOMMENDATION_SCREEN){
                RecommendationScreen(navController)
            }
        }
    }

    object IntroNav {
        const val INTRO_ROUTE = "intro"
        const val INTRO_WELCOME_SCREEN = "welcome"
        const val INTRO_MOTIVATION_SCREEN = "motivation"
        const val INTRO_RECOMMENDATION_SCREEN = "recommendation"
    }


}
