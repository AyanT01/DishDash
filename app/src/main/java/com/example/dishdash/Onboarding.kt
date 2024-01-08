package com.example.dishdash

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.compose.rememberNavController
import com.example.dishdash.ui.theme.DishDashTheme
//import androidx.datastore.createDataStore
//import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
//import androidx.datastore.preferences.core.preferencesKey
//import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
//import com.plcoding.datastoreandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_info")
@Composable
fun Onboarding_Screen(navController:NavController) {
    //val sharedPref = context.getSharedPreferences("YourPrefs", Context.MODE_PRIVATE)
    // val editor = sharedPref.edit()
    //lateinit var dataStore: DataStore<Preferences>
    /*suspend fun save(key:String, value:String) {
        val dataStorekey = stringPreferencesKey(key)
    }*/
    val context =
        LocalContext.current// get your context here, possibly via LocalContext.current or other means
    val first_name = SharedPreferencesManager.getUserData(context, "first_name")
    if (first_name != null) {
        // User data exists
        // Navigate to the profile or other screens
        navController.navigate(Profile.route)
    } else {
        Column {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )
            Row(
                modifier = Modifier
                    .requiredSize(width = 400.dp, height = 100.dp)
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, top = 10.dp)
                    .background(Color(0XFF495E57)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Let's get to know you", fontSize = 26.sp, color = Color.White)
            }
            var first_name by remember {
                mutableStateOf("")
            }
            var last_name by remember {
                mutableStateOf("")
            }
            var email by remember {
                mutableStateOf("")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Personal Information",
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Column() {
                Text(
                    text = "First name",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                OutlinedTextField(
                    value = first_name, onValueChange = { first_name = it },
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Last name",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                OutlinedTextField(
                    value = last_name, onValueChange = { last_name = it },
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Email",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                OutlinedTextField(
                    value = email, onValueChange = { email = it },
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                )
            }

            Row(Modifier.fillMaxHeight()) {
                Button(
                    onClick = { /*"Registration unsuccessful. Please enter all data." */

                        if (first_name == "" || last_name == "" || email == "") {
                            Toast.makeText(
                                context,
                                "Registration unsuccessful. Please enter all data.",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                                Toast.makeText(context,"Registration successful",Toast.LENGTH_SHORT).show()
                                SharedPreferencesManager.saveUserData(context, "first_name",first_name)
                                SharedPreferencesManager.saveUserData(context, "last_name",last_name)
                                SharedPreferencesManager.saveUserData(context, "email",email)
                                val saved_first_name = SharedPreferencesManager.getUserData(context,"first_name")
                                if (saved_first_name != null) {
                                    Log.v("UserName",saved_first_name)
                                }
                            val saved_last_name = SharedPreferencesManager.getUserData(context,"last_name")
                            if (saved_last_name != null) {
                                Log.v("UserName",saved_last_name)
                            }
                            val saved_email = SharedPreferencesManager.getUserData(context,"email")
                            if (saved_email != null) {
                                Log.v("UserName",saved_email)
                            }


                            navController.navigate(Home.route)

                        }
                    }, colors = ButtonDefaults.buttonColors(Color(0XFFF4CE14)), modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Bottom)
                        .padding(20.dp), shape = RoundedCornerShape(20)
                ) {
                    Text(text = "Register", color = Color.Black)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun show_preview() {
    val navController = rememberNavController()
    Onboarding_Screen(navController = navController )
}