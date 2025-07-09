package com.app.myfirebaseauthapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.myfirebaseauthapp.presentation.AuthViewModel
import com.app.myfirebaseauthapp.presentation.ui.HomeScreen
import com.app.myfirebaseauthapp.presentation.ui.LoginScreen
import com.app.myfirebaseauthapp.presentation.ui.SignUpScreen

@Composable
fun FirebaseAuthAppNavigation() {
    val navController = rememberNavController()
    val authViewModel = hiltViewModel<AuthViewModel>()

    NavHost(navController, startDestination = NavRoutes.LoginScreen.route) {
        composable(route = NavRoutes.LoginScreen.route) {
            LoginScreen(
                authViewModel,
                onLoginSuccess = {
                    navController.navigate(NavRoutes.HomeScreen.route) {
                        launchSingleTop = true
                    }
                },
                goToSignUpScreen = {
                    navController.navigate(NavRoutes.SignUpScreen.route){
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(route = NavRoutes.SignUpScreen.route) {
            SignUpScreen(
                authViewModel,
                onSignUpSuccess = {
                    navController.navigate(NavRoutes.HomeScreen.route) {
                        launchSingleTop = true
                    }
                },
                gotToLoginScreen = {
                    navController.navigate(NavRoutes.LoginScreen.route){
                        launchSingleTop = true
                    } }
            )
        }
        composable(route = NavRoutes.HomeScreen.route) {
            HomeScreen()
        }
    }
}