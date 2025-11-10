package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.components.ExplicitNavigation
import com.example.greetingcard.ui.components.ImplicitNavigation
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column {
        Greeting("Karsten Larson", "1400980")
        ExplicitNavigation(
            text = "Start Activity Explicitly",
            activity = SecondActivity::class.java
        )
        ImplicitNavigation(
            text = "Start Activity Implicitly",
        )
        ExplicitNavigation(
            text = "View Image Activity",
            activity = ImageActivity::class.java
        )
    }
}

@Composable
fun Greeting(name: String, id: String, modifier: Modifier = Modifier) {
    Surface(
        color = Color.LightGray,
    ) {
        Text(
            text = "Name: $name\nID: $id",
            modifier = modifier.padding(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        MainScreen()
    }
}