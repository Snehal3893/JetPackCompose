package com.example.composedemo.ui.dashboard.view.activity

import androidx.navigation.NavHostController
import com.example.composedemo.ui.changepwd.ChangePassword
import com.example.composedemo.ui.dashboard.view.activity.AllDestinations.HOME
import com.example.composedemo.ui.dashboard.view.activity.AllDestinations.LOGIN
import com.example.composedemo.ui.dashboard.view.activity.AllDestinations.SETTINGS

object AllDestinations {
    const val LOGIN = "Login"
    const val HOME = "Home"
    const val SETTINGS = "Settings"
}

class AppNavigationActions(private val navController: NavHostController) {

    fun navigateToHome() {
        navController.navigate(HOME) {
            popUpTo(HOME)
        }
    }
fun navigateToLogin(){
    navController.navigate(LOGIN){
        popUpTo(LOGIN)
    }
}
    fun navigateToSettings() {
        navController.navigate(SETTINGS) {
            launchSingleTop = true
            restoreState = true
        }
    }

}
