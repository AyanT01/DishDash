package com.example.dishdash

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Home_Screen(navController: NavHostController) {
    Column {
        Text(text="Home Screen",fontSize=48.sp)
        Button(onClick = {
            navController.navigate(Profile.route)
        }) {
            Text(text="Profile")
        }

    }

}