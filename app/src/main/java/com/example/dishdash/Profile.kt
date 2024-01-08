package com.example.dishdash

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Profile_Screen(navController: NavController) {
    val context = LocalContext.current
    Column {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little Lemon Logo",modifier= Modifier
            .fillMaxWidth()
            .height(50.dp) )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text="Personal Information",modifier=Modifier.padding(horizontal = 20.dp))
        Spacer(modifier = Modifier.height(40.dp))
        Text(text="First Name",modifier=Modifier.padding(horizontal = 20.dp))
        val first_name = SharedPreferencesManager.getUserData(context, "first_name")
        if (first_name != null) {
            Text(text=first_name,modifier=Modifier.padding(horizontal = 20.dp))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text="Last Name",modifier=Modifier.padding(horizontal = 20.dp))
        val last_name = SharedPreferencesManager.getUserData(context, "last_name",)
        if (last_name != null) {
            Text(text=last_name,modifier=Modifier.padding(horizontal = 20.dp))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text="Email",modifier=Modifier.padding(horizontal = 20.dp))
        val email = SharedPreferencesManager.getUserData(context, "email")
        if (email != null) {
            Text(text=email)
        }

        Button(onClick = {
            SharedPreferencesManager.clear(context = context)
            navController.navigate(Onboarding.route)
        }) {
            Text(text = "Logout")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun show_profile() {
    Profile_Screen(navController = rememberNavController())
}