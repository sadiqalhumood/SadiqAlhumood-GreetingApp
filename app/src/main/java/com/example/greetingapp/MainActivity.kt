package com.example.greetingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.greetingapp.ui.theme.GreetingAppTheme
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.time.LocalTime
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ){
                    Column (
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting()
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting() {

    fun getTimeOfDayGreeting(currentTime: LocalTime): String {
        return when (currentTime.hour) {
            in 5..11 -> "Good morning"
            in 12..17 -> "Good afternoon"
            in 18..21 -> "Good evening"
            else -> "Good night"
        }
    }

    var text by remember { mutableStateOf("") }
    var showGreeting by remember { mutableStateOf(false) }
    var currentTime by remember { mutableStateOf(LocalTime.now()) }
    val timeOfDayGreeting = getTimeOfDayGreeting(currentTime)





    Column(

    ) {

        if (showGreeting) {
            Text(
                text = "Hello, $text!",
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "$timeOfDayGreeting!",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter your name") },
            modifier = Modifier.padding(bottom = 16.dp)
        )


        Button(
            onClick = { showGreeting = true }
        ) {
            Text("Greet")
        }
    }
}