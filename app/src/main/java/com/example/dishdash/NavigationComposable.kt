package com.example.dishdash

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable




@Composable
fun Navigation(navController: NavController) {

    NavHost(navController = navController as NavHostController, startDestination = Onboarding.route ) {
        composable(Home.route) {
            Home_Screen()
        }
        composable(Profile.route) {
            Profile_Screen()
        }
        composable(Onboarding.route) {
            Onboarding_Screen(navController)
        }
    }
    //NavHost(navController = navController as NavHostController, startDestination = Home.route)
}
