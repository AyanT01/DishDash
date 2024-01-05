package com.example.dishdash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun Profile_Screen() {
    Column {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Little Lemon Logo" )
        Text(text="Personal Information")
        Text(text="First Name")
        Text(text="Abdul Haq")
        Text(text="Last Name")
        Text(text="Ayantayo")
        Text(text="Email")
        Text(text="abdulhaqayantayo@gmail.com")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Logout")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun show_profile() {
    Profile_Screen()
}