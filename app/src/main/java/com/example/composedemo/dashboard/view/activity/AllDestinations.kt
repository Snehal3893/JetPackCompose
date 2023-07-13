package com.example.composedemo.dashboard.view.activity

import androidx.navigation.NavHostController
import com.example.composedemo.changepwd.ChangePassword
import com.example.composedemo.dashboard.view.activity.AllDestinations.HOME
import com.example.composedemo.dashboard.view.activity.AllDestinations.SETTINGS

object AllDestinations {
    const val HOME = "Home"
    const val SETTINGS = "Settings"
}

class AppNavigationActions(private val navController: NavHostController) {

    fun navigateToHome() {
        navController.navigate(HOME) {
            popUpTo(HOME)
        }
    }

    fun navigateToSettings() {
        navController.navigate(SETTINGS) {
            launchSingleTop = true
            restoreState = true
        }
    }

}
