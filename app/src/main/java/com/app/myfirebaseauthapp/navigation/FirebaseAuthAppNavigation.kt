package com.app.myfirebaseauthapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.myfirebaseauthapp.presentation.ui.HomeScreen
import com.app.myfirebaseauthapp.presentation.ui.LoginScreen
import com.app.myfirebaseauthapp.presentation.ui.SignUpScreen

@Composable
fun FirebaseAuthAppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = NavRoutes.LoginScreen.route) {
        composable(route = NavRoutes.LoginScreen.route) {
            LoginScreen()
        }
        composable(route = NavRoutes.SignUpScreen.route) {
            SignUpScreen()
        }
        composable(route = NavRoutes.HomeScreen.route) {
            HomeScreen()
        }
    }
}