package com.app.myfirebaseauthapp.util

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun DarkItemsStatusLightNavBars(context: Context) {
    LaunchedEffect(Unit) {
        val activity = context as Activity
        val windowInsetsController =
            WindowInsetsControllerCompat(activity.window, activity.window.decorView)
        windowInsetsController.isAppearanceLightNavigationBars = true
        windowInsetsController.isAppearanceLightStatusBars = true

        activity.window.decorView.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        activity.window.statusBarColor = Transparent.toArgb()
        activity.window.navigationBarColor = Black.toArgb()

    }
}