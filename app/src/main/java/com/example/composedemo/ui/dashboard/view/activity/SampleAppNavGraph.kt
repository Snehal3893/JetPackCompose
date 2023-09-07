package com.example.composedemo.ui.dashboard.view.activity

import android.provider.CalendarContract.Colors
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.ui.common.LoginScreen
import com.example.composedemo.ui.home.HomeScreen
import com.example.composedemo.ui.settings.SettingsScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleAppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: AllDestinations.HOME
    val navigationActions = remember(navController) {
        AppNavigationActions(navController)
    }
    var topBarState = rememberSaveable { (mutableStateOf(true)) }

    ModalNavigationDrawer(drawerContent = {
        AppDrawer(
            route = currentRoute,
            navigateToHome = { navigationActions.navigateToHome() },
            navigateToSettings = { navigationActions.navigateToSettings() },
            closeDrawer = { coroutineScope.launch { drawerState.close() } },
            modifier = Modifier
        )
    }, drawerState = drawerState) {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(text = if (currentRoute.equals("Login",true)) "" else currentRoute) },
                    modifier = Modifier.fillMaxWidth(),
                    navigationIcon = { IconButton(onClick = {
                        coroutineScope.launch { drawerState.open() }
                    }, content = {
                        if (currentRoute.equals("Login",true)) "" else
                        Icon(
                            imageVector = Icons.Default.Menu, contentDescription = null
                        )
                    })
                }, colors =
                    if (currentRoute.equals("Login",true)) TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent) else
                    TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer))
            }, modifier = Modifier
        ) {
            NavHost(
                navController = navController, startDestination = AllDestinations.LOGIN, modifier = modifier.padding(it)
            ) {
               // topBarState.value
               composable(AllDestinations.LOGIN){
                   //coroutineScope.launch(coroutineContext) { drawerState.close() }
                   //drawerState.close()
                   topBarState.value=false
                   LoginScreen(navController)
               }
                composable(AllDestinations.HOME) {
                    topBarState.value=true
                    HomeScreen()
                }

                composable(AllDestinations.SETTINGS) {
                    topBarState.value=true
                    SettingsScreen()
                }
            }
        }
    }
}