package com.example.dishdash

import android.content.Context
import android.content.SharedPreferences
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
import androidx.navigation.NavController
//import com.plcoding.datastoreandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    //private var dataStore = DataStore<Preferences>
    //val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "Onboarding")
    //private lateinit var dataStore: DataStore<Preferences>
    //dataStore = createDataStore(name = "settings")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(navController = rememberNavController())

        }


    }


}





















    /*override fun onStart() {
        super.onStart()
        val sharedPreferences = getSharedPreferences("Little Lemon",Context.MODE_PRIVATE)
        val lastCount = sharedPreferences.getInt("StartCount",0)
        val newCount = lastCount + 1
        Log.d("StartCount", "New Count: $newCount")
        sharedPreferences.edit().putInt("StartCount",newCount).apply()

    }*/

            /*DishDashTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //val navController = rememberNavController()
                    //Navigation(navController = navController)
                    //Onboarding_Screen()
                    //Profile_Screen()
                }
            }*/


/*
override fun onStart() {
        super.onStart()
        val sharedPreferences = getSharedPreferences("Little Lemon", MODE_PRIVATE)
            val last_count = sharedPreferences.getInt("StartCount",0)
            val new_count = last_count + 1
            Log.d("StartCount","New Count: $new_count")
            sharedPreferences.edit().putInt("StartCount",new_count).apply()
        }
 */