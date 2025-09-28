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
import com.example.greetingcard.ui.theme.GreetingCardTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SecondScreen(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun SecondScreen(modifier: Modifier) {
    val challenges = listOf(
        "Device Fragmentation",
        "OS Fragmentation",
        "Unstable and Dynamic Environment",
        "Rapid Changes",
        "Tool Support",
        "Low User Tolerance"
    )

    Surface(color = Color.LightGray) {
        Column {
            Text(
                text = "Challenges",
                maxLines = 1,
                modifier = modifier.padding(24.dp)
            )

            for (challenge in challenges) {
                Text(
                    text = "- $challenge",
                    softWrap = true,
                    modifier = modifier.padding(vertical = 2.dp, horizontal = 24.dp)
                )
            }

            ExplicitNavigation("Main Activity", MainActivity::class.java)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    GreetingCardTheme {
        SecondScreen(modifier = Modifier)
    }
}