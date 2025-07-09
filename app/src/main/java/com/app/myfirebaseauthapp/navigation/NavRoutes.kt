package com.app.myfirebaseauthapp.navigation

sealed class NavRoutes(val route: String) {

    data object LoginScreen: NavRoutes(route = "login_screen")
    data object SignUpScreen: NavRoutes(route = "sign_up_screen")
    data object HomeScreen : NavRoutes(route = "home_screen")
}