package com.example.greetingcard.ui.components

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.checkSelfPermission
import com.example.greetingcard.ACTION_CUSTOM

@Composable
fun ExplicitNavigation(text: String, activity: Class<*>, permission: String? = null) {
    val context = LocalContext.current

    Button(
        onClick = {
            val intent = Intent(context, activity)

            if (permission != null && checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(context, "Activity not permitted", Toast.LENGTH_SHORT).show()
                return@Button
            }

            context.startActivity(intent)
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun ImplicitNavigation(text: String, permission: String? = null) {
    val context = LocalContext.current

    Button(
        onClick = {
            val intent = Intent(ACTION_CUSTOM)

            if (permission != null && checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(context, "Activity not permitted", Toast.LENGTH_SHORT).show()
                return@Button
            }

            try {
                context.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "Activity not found", Toast.LENGTH_SHORT).show()
            }
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = text)
    }
}