package com.example.dishdash

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable




@Composable
fun Navigation(navController: NavController) {
    val context =
        LocalContext.current// get your context here, possibly via LocalContext.current or other means
    val first_name = SharedPreferencesManager.getUserData(context, "first_name")
    var startDestination = ""
    if (first_name != null) {
        // User data exists
        // Navigate to the profile or other screens
        startDestination = Home.route
    } else {
        startDestination = Onboarding.route
    }
    NavHost(navController = navController as NavHostController, startDestination = startDestination ) {
        composable(Home.route) {
            Home_Screen(navController)
        }
        composable(Profile.route) {
            Profile_Screen(navController)
        }
        composable(Onboarding.route) {
            Onboarding_Screen(navController)
        }
    }
    //NavHost(navController = navController as NavHostController, startDestination = Home.route)
}
